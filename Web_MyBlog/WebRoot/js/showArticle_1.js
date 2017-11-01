/*
* @Author: Marte
* @Date:   2017-09-01 17:59:02
* @Last Modified by:   Marte
* @Last Modified time: 2017-09-01 18:02:24
*/

'use strict';
    function editor() {
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.uploadImgShowBase64 = true;
        editor.create();
    }
    function addEditor() {

        if ($("#title").val().trim() == ""
                || editor.txt.text().trim() == "请在此处编辑 评论内容") {
            alert("评论内容不能为空!!!");
        } else {

        }
    }