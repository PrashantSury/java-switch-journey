# 🎤 Day 03 – Spring Boot interview answers (review)

![Day](https://img.shields.io/badge/Day-03-blue) ![Q1](https://img.shields.io/badge/Q1-5%2F10-orange) ![Q2](https://img.shields.io/badge/Q2-5%2F10-orange) ![Q3](https://img.shields.io/badge/Q3-7%2F10-yellowgreen) ![Total](https://img.shields.io/badge/total-17%2F30-orange)

> [!TIP]
> Re-read before revising. Answer format to practise: **definition → difference → when to use → example**.
> Source questions: [day03-morning.md](../../tasks/day03-morning.md) · Graded 28 Oct 2026.

> [!WARNING]
> **Total: 17/30.** Q1 and Q2 go to 🔵 Ready for revision. Q3 is solid, with small gaps.

## ❓ Q1. What does idempotent mean? Is DELETE idempotent, and if a client deletes the same id twice, what status should the second call return? Does that break idempotency?

**❌ Your answer (verbatim):**
```diff
- 1. Defination -Idempotent - when we do same request multiple times then it won't affect resource state.
- 2. Yes. DELETE is idempotent. if a client deletes the same id twice still it will give the same status NO_CONTENT.
-    So it wil not break the idempotency.
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-5%2F10-orange) **Grade: 5/10 – definition close, conclusion right, but the status-code claim is wrong for your own API.**

**🔧 Corrections**
```diff
- the second DELETE gives the same status NO_CONTENT
+ the second DELETE on your API gives 404 (see your deleteUnknown test), and that is fine
```
- ✅ Definition is close. Sharper: making the same request **N times leaves the server state the same as making it once**. The **response may differ**.
- ❌ Your API returns **404** on the second DELETE, not 204. `StudentServiceImpl.delete` throws `StudentNotFoundException` for an unknown id, and your `deleteUnknown` test checks exactly that.
- 📌 **404 does NOT break idempotency.** Idempotency is about the **server state**, not the status code. After the first call the student is gone, and after the second call the student is still gone.

**✅ Model answer**
> [!TIP]
> An operation is idempotent if repeating the same request N times leaves the **server state** the same as sending it once. The response can differ between calls. GET, PUT and DELETE are idempotent, and POST is not. DELETE is idempotent: the first call returns 204 and removes the student. A second call on my API returns 404 because the resource no longer exists. That doesn't break idempotency, since the state (student is gone) is the same after one call or ten. Some APIs return 204 every time, which is also valid.

## ❓ Q2. `ResponseEntity` vs `@ResponseStatus`: when would you use each, and why return a `Location` header with 201?

**❌ Your answer (verbatim):**
```diff
- ResponseEntity -
- 1. It is used to give condtional responses for REST API.
- 2. When we want to give the response with body then we can use pattern like ResponseEntity.status(HttpStatus.Code).body(Object)
-    Here Code can 1xx, 2xx, 3xx, 4xx, 5xx as respective enums.
- 3. When we want to give the response without body then we can use pattern like ResponseEntity.noContent().build();
-    and here in place noContent(), there are different methods also available like notFound().
-
- ResponseStatus -
- 1. It is used to static response i.e; about which we are sure that the REST API will response with this status code.
- 2. It is return with @ResponseStatus (HttpStatus.Code)
-    Here Code can 1xx, 2xx, 3xx, 4xx, 5xx as respective enums.
-
- When we create any resource using the HTTP POST method then to cross verify if the resource is correctly or not.
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-5%2F10-orange) **Grade: 5/10 – the builder syntax is right, but the big idea and the `Location` answer are missing.**

**🔧 Corrections**
- `ResponseEntity` gives you **runtime control of the status, the headers and the body**. That is how you set `Location`, and how you choose different statuses in `if/else` branches.
- `@ResponseStatus` sets a **fixed status**. You can put it on a handler method, and also on **exception classes**, e.g. `@ResponseStatus(HttpStatus.NOT_FOUND)` on `StudentNotFoundException`.
- ❌ `Location` is not there "to cross verify". With **201 Created**, `Location` is the **URL of the new resource**, so the client can GET it without building the URL itself.

**✅ Model answer**
> [!TIP]
> `ResponseEntity` represents the whole HTTP response, so I use it when the status, headers or body are decided at runtime, for example `ResponseEntity.created(uri).body(dto)` or `ResponseEntity.noContent().build()`. `@ResponseStatus` declares a fixed status for a handler method or an exception class (`@ResponseStatus(NOT_FOUND)` on `StudentNotFoundException`), and I use it when the outcome never varies. After a POST creates a resource I return **201** with a **`Location` header** holding the URL of the new resource (built with `ServletUriComponentsBuilder`), so the client knows where to fetch it.

## ❓ Q3. What happens when a required `@RequestParam` is missing? How do you make it optional, and what does `@Valid` on a plain `String` param do?

**❌ Your answer (verbatim):**
```diff
- Required @RequestParam is missing then we get BAD REQUEST response. if we want to make it optional then we can make the required == false or set
- defaultValue. @Valid is not validated the plain string. So we should not add the @Valid annotation to the plain string
```

> [!NOTE]
> ![Grade](https://img.shields.io/badge/grade-7%2F10-yellowgreen) **Grade: 7/10 – correct on 400, `required = false` and `defaultValue`; a few details missing.**

**🔧 To score higher**
- ✅ Name the exception: `MissingServletRequestParameterException` (Spring turns it into **400**).
- ✅ Third way to make it optional: use `Optional<String>`.
- ✅ Say what to do instead of `@Valid`: put **`@NotBlank` on the parameter**, with `@Validated` on the controller class. Spring 6.1+ has built-in method validation.

**✅ Model answer**
> [!TIP]
> A required `@RequestParam` that is missing throws `MissingServletRequestParameterException`, which gives **400 Bad Request**. To make it optional I use `required = false`, `defaultValue`, or `Optional<String>`. `@Valid` on a plain `String` does nothing, because there are no constraints on `String` to cascade into. To validate it, I put a constraint such as `@NotBlank` directly on the parameter, and Spring 6.1+ built-in method validation checks it.

## 🏁 Summary
| Q | Topic | Grade | Status |
|---|---|---|---|
| 1 | Idempotency, DELETE twice | 5/10 | 🔵 Ready for revision |
| 2 | `ResponseEntity` vs `@ResponseStatus`, `Location` | 5/10 | 🔵 Ready for revision |
| 3 | Missing `@RequestParam`, optional, `@Valid` on `String` | 7/10 | ✅ Graded (small gaps) |
| | **Total** | **17/30** | |
