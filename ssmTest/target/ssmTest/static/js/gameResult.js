// $(function () {
//     alert("当前gameResult页面，前方进入ajax");
//     $.ajax({
//         type: 'GET',
//         url: '/gameController/gameOver',
//         dataType: 'json',
//         async:true,
//         success: function(res) {
//             alert("请求成功！");
//             alert(eval(res));
//         },
//         error: function (XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.status);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//             alert(errorThrown);
//             alert("请求失败！");
//             console.log('请求失败~');
//         }
//     });
// })
//
/**暂时无法显示结果！！！不清楚状况，可以后面再进行调试。**/
isOver = function () {
    alert("isOver 函数调用成功！前方进入ajax");
    document.getElementById("getResult").style.display="none";
    document.getElementById("back").style.display="block";
    $.ajax({
        url: '/gameController/gameOver',
        type: 'GET',
        dataType: 'json',
        async:true,
        success: function(res) {
            // var obj = JSON.parse(res);
            // alert("请求成功！");
            // alert(res);
            // alert(JSON.stringify(res));
            var temp = JSON.stringify(res).replace(/:\s*[^\d|^\"]*/g, ':');
            var obj = $.parseJSON(temp);

            // if(res.length==4){
            // alert(obj);
            // alert("紧急预告！！！");
            $("#result").append("<tr><th>玩家</th><th>提交的数字</th></tr>");
            for(var key in obj){
                var tr = $("<tr><td>"+ key +"</td><td>"+ obj[key] +"</td></tr>");
                $("#result").append(tr);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
            alert(errorThrown);
            alert("请求失败！");
            console.log('请求失败~');
        }
    });
}

back = function () {
    url="/gameController/backToIndex";
    location.href=url;
}
// var myInterval = setInterval(isOver, 3000);//设置定时调用 isOver()函数，对Controller进行请求,实时获取当前已经提交的数据。