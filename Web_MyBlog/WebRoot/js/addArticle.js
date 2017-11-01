/*
* @Author: Marte
* @Date:   2017-09-01 17:59:02
* @Last Modified by:   Marte
* @Last Modified time: 2017-09-01 18:00:36
*/

'use strict';
    var editor;
    function editor() {
        var E = window.wangEditor;
        editor = new E('#editor');
        editor.customConfig.uploadImgShowBase64 = true;
        editor.create();
    }
    function addEditor() {
        $("#tit").val($("#title").val().trim());
        $("#content").val(editor.txt.text().trim());
        $("#content_html").val(editor.txt.html());
        $("#time").val(getnowtime());
        if ($("#title").val().trim() == ""
                || editor.txt.text().trim() == "请在此处编辑 文章内容") {
            alert("文章标题和内容不能为空!!!");
        } else {
             $(location).attr("href", "ArticleServlet?action=add");
            /*  $.post("ArticleServlet?action=add", {
                    "title" : $("#title").val().trim(),
                    "content" : editor.txt.text().trim(),
                    "content_html" : editor.txt.html(),
                    "time" : getnowtime()
                }, function(data) {
                }, "json");*/
        }
    }
    function getnowtime() {
        var nowtime = new Date();
        var year = nowtime.getFullYear();
        var month = padleft0(nowtime.getMonth() + 1);
        var day = padleft0(nowtime.getDate());
        var hour = padleft0(nowtime.getHours());
        var minute = padleft0(nowtime.getMinutes());
        var second = padleft0(nowtime.getSeconds());
        var millisecond = nowtime.getMilliseconds();
        millisecond = millisecond.toString().length == 1 ? "00" + millisecond
                : millisecond.toString().length == 2 ? "0" + millisecond
                        : millisecond;
        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":"
                + second + "." + millisecond;
    }
    //补齐两位数
    function padleft0(obj) {
        return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
    }