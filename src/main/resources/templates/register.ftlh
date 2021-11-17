<#import "parts/common.ftlh" as p>
<#import "parts/login.ftlh" as l>
<@p.page>
<#if message??>
<div class="alert alert-danger d-flex align-items-center" role="alert">
    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
    <div class="fs-4">
    ${message!""}
    </div>
</div>
</#if>
<div class="fs-3 d-grid gap-2 col-2 mx-auto mb-5">
    <b>REGISTRATION</b>
</div>
<@l.login "/register" true/>
</@p.page>