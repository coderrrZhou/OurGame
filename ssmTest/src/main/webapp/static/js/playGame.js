
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

// //计算提交       -------------待调用，待测试
// onclick_Submit = function () {
//     alert("you have submit your number!");
//     var tempNums=document.getElementById('myNums').value;
//     totalNums += tempNums;
//     numsArray[nums_HasSubmit] = tempNums;
//     nums_HasSubmit++;
//     if(nums_HasSubmit==totalPlayers){
//         alert("已经全部提交");
//         var G = totalNums/totalPlayers;
//         //算出结果后，将数据传到后台Controller调用dao存储，进入下一局游戏
//         var url = "/gameController/getG?G=";
//         location.href=url+G;
//     }
// }


