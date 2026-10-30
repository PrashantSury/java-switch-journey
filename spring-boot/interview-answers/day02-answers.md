# 🎤 Day 02 – Spring Boot interview answers (review)

![Day](https://img.shields.io/badge/Day-02-blue) ![Q1](https://img.shields.io/badge/Q1-5%2F10-orange) ![Q2](https://img.shields.io/badge/Q2-7%2F10-yellowgreen) ![Q3](https://img.shields.io/badge/Q3-5%2F10-orange)

> [!TIP]
> Re-read before revising. Answer format to practise: **definition → difference → when to use → example**.

## ❓ Q1. `@PathVariable` vs `@RequestParam` vs `@RequestBody` – when would you use each?

**❌ Your answer (verbatim):**
```diff
- @PathVariable - it is the annotation used to pass the variable to api as mandatory parameter and it is not passde then will get HTTP 404 error
- @RequestParam - it is annotation used to pass as parameter but it is not mandatory
- @RequestBody - it is annotation used to convert the json body to DTO class
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-5%2F10-orange) **Grade: 5/10 – partly right, one factual error, "when to use" missing.**

**🔧 Corrections**
```diff
- @RequestParam ... it is not mandatory
+ @RequestParam is required by default (required = true) -> missing param gives 400
```
- `@PathVariable`: say it binds a **segment of the URI path** (`/students/{id}`) that **identifies a resource**. The 404 point is fair: without the segment, the URL doesn't match the mapping.
- `@RequestParam` is **required by default** (`required = true`). If it's missing you get **400 Bad Request** (`MissingServletRequestParameterException`). It's optional only with `required = false` or a `defaultValue`.
- `@RequestBody`: deserialises the HTTP **request body** into an object using an `HttpMessageConverter` (Jackson for JSON). Pair it with `@Valid` to get 400 errors on bad fields.
- You didn't say **when** to use each one, which was half of the question.

**✅ Model answer**
> [!TIP]
> `@PathVariable` binds part of the URL path, e.g. `GET /students/{id}`. I use it to identify a specific resource. `@RequestParam` binds query-string or form parameters, e.g. `GET /students/search?name=ram`. I use it for filtering, sorting, paging and other optional inputs. It is required by default, so a missing param gives 400 unless I set `required=false` or a `defaultValue`. `@RequestBody` deserialises the request body (JSON) into a DTO through Spring's HttpMessageConverters (Jackson). I use it for POST/PUT/PATCH payloads, usually with `@Valid`. Example: `PUT /students/{id}` takes the id from `@PathVariable` and the new data from `@RequestBody`.

## ❓ Q2. `@RestController` vs `@Controller` – what does `@RestController` add?

**❌ Your answer (verbatim):**
```diff
- @RestController - it is combination of @Controller & @ResponsBody
```

> [!NOTE]
> ![Grade](https://img.shields.io/badge/grade-7%2F10-yellowgreen) **Grade: 7/10 – correct, but too short.**

**🔧 Corrections**
- Explain what that **means**: with `@Controller`, a returned `String` is treated as a **view name** and resolved by a ViewResolver (Thymeleaf/JSP). With `@RestController`, every handler's return value is **serialised straight into the response body** (JSON through Jackson).
- Mention the use case: `@Controller` for server-rendered pages, `@RestController` for REST APIs. (Small spelling slip: it's `@ResponseBody`.)

**✅ Model answer**
> [!TIP]
> `@RestController` is a meta-annotation: `@Controller` + `@ResponseBody` on every method. A plain `@Controller` returns view names that a ViewResolver renders as HTML. `@RestController` skips view resolution and writes the return value to the HTTP response body with an HttpMessageConverter, usually as JSON. I use `@Controller` for MVC pages and `@RestController` for REST APIs.

## ❓ Q3. Should PUT be idempotent? PUT vs PATCH? Status codes for create / update / delete?

**❌ Your answer (verbatim):**
```diff
- PUT is used to update the particular columns in the DB for the respective Object and it takes the whole object as its input and PATCH - is also used to update a particular column and it accepts that column value as parameter.
- CREATE - 201, update - 200, delete -204
```

> [!WARNING]
> ![Grade](https://img.shields.io/badge/grade-5%2F10-orange) **Grade: 5/10 – status codes are good; the idempotency part wasn't answered.**

**🔧 Corrections**
```diff
- PUT is used to update the particular columns in the DB
+ PUT is idempotent and replaces the whole resource
- PATCH ... accepts that column value as parameter
+ PATCH is a partial update (fields in the body), not guaranteed idempotent
- CREATE - 201
+ CREATE - 201 Created + Location header
```
- You never answered **"Should PUT be idempotent?"** → **Yes.** Define it: *idempotent = sending the same request N times leaves the server in the same state as sending it once.*
- PUT **replaces the whole resource** with the representation you send. Fields you leave out get reset or nulled. It's not "particular columns". Talk about HTTP resources, not DB columns.
- PATCH applies a **partial update** (only the fields sent, in the body, not as a parameter). It is **not guaranteed to be idempotent**, e.g. `{"op":"increment"}`.
- Status codes: create **201 Created + `Location` header**. Update **200 OK** (with body) or **204 No Content**. Delete **204**. Missing resource **404**. Validation error **400**. PUT can also create (201) if the client picks the id.
- Bonus vocabulary: GET, PUT and DELETE are idempotent. POST is not. GET is also *safe* (no side effects).

**✅ Model answer**
> [!TIP]
> Yes, PUT should be idempotent: repeating the same PUT gives the same server state. PUT sends the full representation and replaces the resource. PATCH sends only the changes (a partial update) and isn't necessarily idempotent. POST create returns 201 Created with a Location header. Update returns 200 with the updated body, or 204 if there's no body. Delete returns 204. Unknown id returns 404, and an invalid body returns 400.

## 🔥 What to focus on

> [!IMPORTANT]
> Work through these before the next Spring round.

1. **Answer structure:** definition → difference → when to use → short example. Always answer *every* part of the question (you skipped "when" in Q1 and "should PUT be idempotent" in Q3).
2. **Know the defaults:** `@RequestParam(required = true)` → 400. `@PathVariable` is required. `@ResponseStatus` defaults to 200. Interviewers love asking about defaults.
3. **HTTP semantics vocabulary:** idempotent, safe, full replacement vs partial update, status codes 200/201/204/400/404/409, and the `Location` header.
4. **Precise terms:** "URI path segment", "query parameter", "request body", "HttpMessageConverter/Jackson", "deserialise", "view resolution". Say "resource", not "DB columns".
5. **Tie it to your code:** e.g. "In my Student API, PUT /api/students/{id} uses @PathVariable for id and @Valid @RequestBody for the data."
