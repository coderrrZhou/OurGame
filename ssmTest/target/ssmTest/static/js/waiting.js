var currentPlayers;

//返回主页
onclick_OutRoom = function(r){
    /**
     * 传递字符串参数
     **/
    // alert("返回onclick_JoinRoom");
    // alert(r.getAttribute('thisRoom'));
    var param=r.getAttribute('thisRoom');
    var url = "/roomController/roomBack?rId=";
    location.href=url+param;
}

startGame = function () {
    var url = "/roomController/gameStarting";
    location.href = url;
}

//用于异步请求实时刷新当前房间的用户，判断开始游戏的时间 ----------  因测试开始游戏功能，暂时注释掉
reqs = function() {
    // alert("reqs 函数调用成功！前方进入ajax");
    $.ajax({
        type: 'GET',
        url: '/roomController/getCurrentPlayerNums',
        dataType: 'json',
        async:true,
        success: function(res) {
            // alert("请求成功！");
            // alert(eval(res));
            currentPlayers = eval(res);
            if(currentPlayers==3){
                /**当房间内玩家达到足够人数，自动跳转到room中开始游戏**/
                clearInterval(myInterval);
                var url = "/roomController/gameStarting";
                location.href=url;

            }

            // Document.getElementById('thePlayerNums').innerHtml = currentPlayers;
            document.getElementsByTagName('b')[0].innerHTML = '当前房间人数：'+currentPlayers;
            console.log(res);
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
reqs();
var myInterval = setInterval(reqs, 3000);//设置定时调用reqs()函数，对Controller进行请求。
