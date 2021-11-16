<#import "parts/common.ftlh" as p>

<@p.page>
<h3>Create note</h3>
<div class="form-group mt-3">
    <form method="post" action="create">
        <div class="mb-3">
            <label for="noteNameInput"  class="form-label">Note name</label>
            <input type="text" class="form-control" name="noteName" id="noteNameInput" placeholder="Enter note's name">
        </div>
        <div class="mb-3">
            <label for="noteTextarea"  class="form-label">Note text</label>
            <textarea class="form-control" name="noteText" id="noteTextArea" style="resize:none" rows="20"></textarea>
        </div>
        <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">Access Types</legend>
            <div class="col-sm-2 ">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="access" id="Privat" value="privat" checked>
                    <label class="form-check-label" for="Privat">
                        Privat
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
        <input type="hidden" name="_csrf" value="{_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-3">Add note</button>
    </form>
</div>
</@p.page>