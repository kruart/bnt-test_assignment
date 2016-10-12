$(document).ready(function () {
   $(".addFileField").click(function () {
        $("form > input:file:last").after("<br/>Upload File: <input type='file' name='file'> <br/>");
   });
});