# 🎤 Day 04 – Spring Boot interview answers (review)

![Day](https://img.shields.io/badge/Day-04-blue) ![Q1](https://img.shields.io/badge/Q1-5%2F10-orange) ![Q2](https://img.shields.io/badge/Q2-4%2F10-red) ![Q3](https://img.shields.io/badge/Q3-6%2F10-orange) ![Total](https://img.shields.io/badge/total-15%2F30-orange)

> [!IMPORTANT]
> Re-read before revising. Answer format to practise: **definition → difference → when to use → example**. All three answers are partial, so the set is 🔴 Needs correction until you re-answer Q1-Q3 in chat (by Tue 3 Nov).

> [!NOTE]
> **Legend:** ❌ your answer (verbatim) · ✅ correct · ⚠️ gap · 🔧 correction · grade badges: red < 5, orange 5-6, yellowgreen 7-8, brightgreen 9-10. Source questions: [day04-morning.md](../../tasks/day04-morning.md) · Answered in chat and graded 31 Oct 2026. Section: §5 Validation and error handling (with §2 Request flow).

> [!WARNING]
> **Total: 15/30.** Q1, Q2 and Q3 are all 🔴 Needs correction. Q1 and Q3 are logged in [mistakes/spring.md](../../revision/mistakes/spring.md) (redo 3 Nov and 7 Nov).

## ❓ Q1. How does a JSON body become a validated `StudentRequest`? Which component converts it, which exception is thrown when validation fails, and what happens with malformed JSON?

**❌ Your answer (verbatim):**
```diff
- @RequestBody - with the help this JSON Body converts into a DTO via Jackson. HttpMessageConverter is responsibile for conversion, exception thrown is "HttpMessageNotReadableException".  Malformed JSON give 400 - Bad Request
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-5%2F10-orange) **Grade: 5/10 – conversion and malformed JSON are right, but the validation exception is missing (you named the malformed-JSON exception instead).**

**🔧 Corrections**
```diff
- the exception thrown when validation fails is HttpMessageNotReadableException
+ validation failure throws MethodArgumentNotValidException; HttpMessageNotReadableException is for unreadable or malformed JSON
```
- ✅ `@RequestBody` hands the body to an **`HttpMessageConverter`** (Jackson for JSON), which builds the `StudentRequest`.
- ✅ Malformed JSON, or a wrong type that Jackson can't read, gives **`HttpMessageNotReadableException` → 400**.
- ❌ Validation is a **separate step after conversion**. With `@Valid` on the parameter, a failed constraint (`@NotBlank`, `@Size`, `@Email`) throws **`MethodArgumentNotValidException`** (its `BindingResult` holds the field errors), which also gives **400**.
- ⚠️ Two different exceptions, both 400, so `@RestControllerAdvice` needs **two handlers**. That is exactly what Part B2 asks for.

**✅ Model answer**
> [!TIP]
> `@RequestBody` makes Spring pick an `HttpMessageConverter` (Jackson for JSON) that reads the body into a `StudentRequest`. If the JSON is malformed or has a type Jackson can't read, the conversion fails with `HttpMessageNotReadableException` and the client gets 400. If the JSON is readable and the parameter has `@Valid`, the constraints are checked next, and a failure throws `MethodArgumentNotValidException`, also 400, with the field errors in its `BindingResult`. Two different exceptions at two different steps, so I handle both in `@RestControllerAdvice` and return a `ProblemDetail` for each.

## ❓ Q2. Why keep separate request and response DTOs instead of exposing the `Student` entity? Give two concrete risks.

**❌ Your answer (verbatim):**
```diff
-  Required parameters can be requested and same for response instead exposing the actual DTO.
-     Student entity is exposed then we might not know that user can assign any value to the fields
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-4%2F10-red) **Grade: 4/10 – you half-got mass assignment, but the answer is vague and gives only one risk.**

**🔧 Corrections**
- ⚠️ "Required parameters can be requested" is the right idea (a DTO carries only the fields that use case needs), but it isn't a risk. Say what goes wrong without it.
- ✅ "A user can assign any value to the fields" is **mass assignment (over-posting)**: the client sends `id`, `createdAt` or an `admin` flag in the JSON and Jackson writes it into the entity.
- ❌ Missing risk: **leaking internal fields or lazy relations**. The response can expose fields the client must never see (a password hash, internal flags), or trigger `LazyInitializationException`, extra queries or infinite recursion on bidirectional relations when Jackson walks the entity.
- ❌ Missing risk: **coupling the API to the DB schema**. Renaming a column or splitting a table then breaks every client, and one entity can't carry different rules for create and update.

**✅ Model answer**
> [!TIP]
> Separate DTOs keep the API contract independent of the entity. If I bind a request straight into `Student`, a client can set fields it shouldn't (`id`, `createdAt`, a role flag): mass assignment. If I return the entity, I can leak internal fields or lazy relations (extra queries, `LazyInitializationException`, recursion in JSON), and every schema change becomes an API change. With a `StudentRequest` (only the editable fields, plus validation) and a `StudentResponse` (only what clients may see), the controller controls exactly what goes in and out.

## ❓ Q3. What is `ProblemDetail`? Why is 409 better than 400 for a duplicate email, and why isn't the "does it exist" check alone enough to keep emails unique?

**❌ Your answer (verbatim):**
```diff
- ProblemDetail is Spring’s built-in class (Spring 6 / Boot 3+) for returning errors in the standard RFC 7807 / RFC 9457 format, application/problem+json.
-
- 400 Bad Request → the request itself is malformed or invalid
-                   (bad JSON, missing field, wrong type, failed @Valid)
-
- 409 Conflict    → the request is well-formed and valid, but it
-                   conflicts with the CURRENT STATE of the server
```
> You did not answer the last part: why the "does it exist" check alone isn't enough.

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-6%2F10-orange) **Grade: 6/10 – `ProblemDetail` and 400 vs 409 are correct and well put, but the third part (the race condition) is missing.**

**🔧 Corrections**
- ✅ `ProblemDetail` and the RFC 7807 / 9457 format are correct.
- ✅ 400 = the request itself is bad, 409 = a valid request that clashes with the current state. A duplicate email is the second case.
- ❌ **Check-then-save is not atomic.** Two requests with the same email can both pass `existsByEmail...` before either saves, and both then insert. The check only gives a friendly early error.
- 🔧 The real guarantee is a **unique constraint in the database** (your `email` column has none yet; since you compare ignoring case, use a unique index on `lower(email)`). The loser of the race then fails with **`DataIntegrityViolationException`**, and you **map that to 409** in the advice, the same response as the exists check.

**✅ Model answer**
> [!TIP]
> `ProblemDetail` is Spring's built-in class (Spring 6 / Boot 3+) for the RFC 7807 / 9457 error format, `application/problem+json`. A duplicate email is a valid request that conflicts with the current state, so it is 409, while 400 is for a malformed or invalid request (bad JSON, failed `@Valid`). The "does it exist" check alone isn't enough because check-then-save isn't atomic: two concurrent requests can both see "not found" and both save. I keep the check for a clean early 409, but the guarantee is a unique constraint on the email column, and I catch `DataIntegrityViolationException` and return the same 409 `ProblemDetail`. (This comes back in §6 JPA.)

## 🏁 Summary
| Q | Topic | Grade | Status |
|---|---|---|---|
| 1 | JSON → DTO, validation vs malformed JSON exceptions | 5/10 | 🔴 Needs correction |
| 2 | Request/response DTOs vs the entity | 4/10 | 🔴 Needs correction |
| 3 | `ProblemDetail`, 400 vs 409, the race condition | 6/10 | 🔴 Needs correction |
| | **Total** | **15/30** | Re-answer Q1-Q3 by Tue 3 Nov |
