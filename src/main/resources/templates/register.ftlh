<#import "parts/common.ftlh" as p>
<#import "parts/login.ftlh" as l>
<@p.page>
    ${message!""}
<div class="mb-1">
<u>Add new user</u>
</div>
<@l.login "/register" true/>
</@p.page>