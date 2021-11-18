<#macro editForm>
<div class="form-group mt-3">
    <form method="post" action="/note/create" modelAttribut>
        <div class="mb-3">
            <label for="noteNameInput" class="form-label">Note name</label>
            <input type="text" class="form-control" name="noteName" id="noteNameInput" placeholder="Enter note's name" value="<#if note??>${note.name}<#else>""</#if>">
        </div>
        <div class="mb-3">
            <label for="noteTextarea" class="form-label">Note text</label>
            <textarea class="form-control" name="noteText" id="noteTextArea" style="resize:none" rows="20" placeholder="Enter your note"><#if note??>${note.message}</#if></textarea>
        </div>
        <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">Access Types</legend>
            <div class="col-sm-2 ">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="access" id="Private" value="private" checked>
                    <label class="form-check-label" for="Private">
                        Private
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="access" id="Public" value="public">
                    <label class="form-check-label" for="Public">
                        Public
                    </label>
                </div>
            </div>
        </fieldset>
        <input type="hidden" class="form-control" name="noteID" value="<#if note??>${note.id}<#else>""</#if>">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="d-flex justify-content-end">
            <button type="button" class="btn btn-outline-primary m-2" onclick="location.href='/note/list'">Cancel</button>
            <button type="submit" class="btn btn-primary m-2">Save note</button>
        </div>
    </form>
</div>
</#macro>