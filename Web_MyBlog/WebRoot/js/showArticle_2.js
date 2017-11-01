/*
* @Author: Marte
* @Date:   2017-09-01 17:59:02
* @Last Modified by:   Marte
* @Last Modified time: 2017-09-01 18:04:07
*/

'use strict';
var agoComment =[];
    <c:forEach items="${clist }" var="comment">
        var a ={"id":'${comment.cmt_id}',"userName":'${comment.userName}',"aid":'${comment.aid}',"sortID":0,"time":'${comment.cmtDate}',"content":'${comment.content}'};
        agoComment.push(a);
  </c:forEach>
$("#articleComment").zyComment({
    "width":"350",
    "height":"30",
    "agoComment":agoComment,
    "callback":function(comment){
        console.info("填写内容返回值：");
        console.info(comment);
        // 添加新的评论
        var content = $("#commentContent").val();
        var name = '${empty user.userName?"游客:":user.userName}';
        $("#articleComment").zyComment("setCommentAfter",{"name":name, "content":content, "time":getnowtime()});
        $.post('CommentServlet?action=add&aid=${art.aid}&content='+content+'&userName='+name+'&cmtDate='+getnowtime());
//      $(location).attr("href", 'CommentServlet?action=add&aid=${art.aid}&content='+content+'&userName='+name+'&cmtDate='+getnowtime());
    }

});

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
                + second;
    }
    //补齐两位数
    function padleft0(obj) {
        return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
    }