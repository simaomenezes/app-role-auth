# app-role-auth

<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/t/simaomenezes/app-role-auth">
<img alt="GitHub Actions Workflow Status" src="https://img.shields.io/github/actions/workflow/status/simaomenezes/app-role-auth/gradle.yml">
<img alt="GitHub branch check runs" src="https://img.shields.io/github/check-runs/simaomenezes/app-role-auth/main">



<h2>app-role-auth / Role-Based Access Control - RBAC</h2>

📌 Controller Test - (Permission)
<p>TEST-1 Integration Given Permission Object when Create one Permission should Return a Permission.  ( ✅ )</p>
<p>TEST-2 Integration Given Permission Object when List all Permission should Return a Permission Object.  ( ✅ )</p>
<p>TEST-3 Integration Given Permission Object when Update one Permission should Return a Permission Object.  ( ✅ )</p>


📌 UseCase Test - (Permission)
<p>TEST-1: CreatePermissionUseCase ( ✅ )</p>
<p>TEST-2: DeletePermissionUseCase ( ✅ )</p>
<p>TEST-3: UpdatePermissionUseCase ( ✅ )</p>
<p>TEST-4: ListAllPermissionUseCase ( ✅ )</p>

📌 Repository Test - (Permission)
<p>TEST-1: Should save permission Object on database. ( ✅ )</p>
<p>TEST-2: Should update Permission name Object when findByName Permission then Return Permission name Object. ( ✅ ) *</p>
<p>TEST-3: Given Permission Id when Delete Permission then do nothing. ( ✅ ) *</p>
<p>TEST-4: Given Permission List when list all then return list.   ( ✅ )</p>
<p>TEST-5: Given name Permission when Find By Name then Return Permission Object.   ( ✅ )</p>
<p>TEST-6: Given id Permission when Find By Id then Return Permission Object.   ( ✅ )</p>

📌 Domain Test - (Permission)
<p>TEST-1: Should an exception when name exist. ( ✅ )</p>
<p>TEST-2: Not Should an exception when name don't already. ( ✅ ) *</p>