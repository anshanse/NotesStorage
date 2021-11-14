<#macro login path isRegisterForm>
<form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group col-sm-4">
        <label for="inputUserName" class="col-sm-3 form-label"> User Name :</label>
        <input type="text" class="form-control" id="inputUserName" placeholder="Enter login" name="username"/>
    </div>
    <div class="form-group col-sm-4">
        <label for="inputPassword" class="col-sm-2 form-label"> Password:</label>
        <input type="password" class="form-control" id="inputPassword" placeholder="Enter password" name="password"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="mt-2"><#if !isRegisterForm><a href="/register">Add new user</a></#if></div>
<div><input type="submit" class="btn btn-primary mt-3" value="<#if isRegisterForm>Create<#else>Sign In</#if>"/></div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post" class="mx-2">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" class="btn btn-light" value="Sign Out"/>
</form>
</#macro>