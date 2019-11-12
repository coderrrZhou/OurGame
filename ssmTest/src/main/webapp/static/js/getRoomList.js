$(function(){
    // alert("前方ajax！");
    $.ajax({
        type:"GET",
        url:"/roomController/proRoom",
        // contentType:"application/json",
        dataType:'json',
        // data:{},
        async:true,
        success:function(data){
            // alert("success!");
            // alert(JSON.stringify(data));
            // for(var i=0;i<data.news.length;i++){
            //     var d=data.news[i].releaseTime.split(" ");
            //     var li=$("<li><div class='title'><h6><a href='announcementsArticle.html?newsId="+data.news[i].id+"'>"+data.news[i].themeName+"</a></h6><span class='date'>"+d[0]+"</span></div> </li>");
            //     $("#all").append(li);
            // }
            var obj=eval(data);
            $(obj).each(function (index){
                var val = obj[index];
                var li = $("<li style='float: left'><div class='roomTitle' onclick='onclick_JoinRoom(this)' thisRoom='"+val.roomId+"' style='float: left;width: 100px; background-color: #FBEC88;margin: 50px 0 0 100px;height: 200px;width: 250px; text-align:center;line-height: 200px;font-size: 20px; font-family: 隶书;'>"+ val.roomId +"进入房间</div></li>");
                // var li = $("<div class='roomTitle'style='float: left;width: 100px; background-color: red;margin: 50px 0 0 100px;'>"+ val.roomId +"</div>");
                $("#all").append(li);
            });
            var a = document.getElementById("all").getElementsByTagName("li");
            // var a = document.getElementById("all");
            var zz =new Array(a.length);
            for(var i=0;i <a.length;i++)
            { zz[i]=a[i].innerHTML } //div的字符串数组付给zz
            var pageno=1;           //当前页
            var pagesize=6;            //每页多少条信息
            if(zz.length%pagesize==0)
            {var  pageall =zz.length/pagesize }
            else
            {var  pageall =parseInt(zz.length/pagesize)+1}       //一共多少页
            $("#p").text(pageall);      //将pageall的值存放到div中，便于下次使用
            change(1,pageall,zz);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
           alert(XMLHttpRequest.status);
           alert(XMLHttpRequest.readyState);
           alert(textStatus);
           alert(errorThrown);
        }
    });
})



//分页
var k;
function change(e,all,zu){
    zz=zu;
    var pagesize=6;
    pageall=all;
    pageno=e;
    if(e <1)//如果输入页<1页
    { e=1;pageno=1}//就等于第1页 ， 当前页为1
    if(e>pageall)//如果输入页大于最大页
    {e=pageall;pageno=pageall}//输入页和当前页都=最大页
    document.getElementById("all").innerHTML="";//全部清空
    for(var i=0;i<pagesize;i++)
    {
        var div =document.createElement("div");//建立div对象
        div.innerHTML=zz[(e-1)*pagesize+i];//建立显示元素
        document.getElementById("all").appendChild(div);//加入all中
        if(zz[(e-1)*pagesize+i+1]==null)//超出范围跳出
            break
    }
    var ye="";
    for(var j=1;j<=pageall;j++)
    {
        if(e==j)
        {ye=ye+"<span><a href='#' onClick='change1("+j+")' style='color:#FF0000'>"+j+"</a></span> "}
        else
        {ye=ye+"<a href='#' onClick='change1("+j+")'>"+j+"</a> "}
    }
    document.getElementById("a1").innerHTML=pageall;
    document.getElementById("a2").innerHTML=pageno;
    document.getElementById("a3").innerHTML=ye;

    /*如果当前是第一页则：*/

    if (pageno == 1)
    {
        $('#down').hide();//隐藏
    }else {
        $('#down').show();//显示
    }

    /*如果是最后一页则：*/

    if (pageno == pageall)
    {
        $('#up').hide();//隐藏
    }else {
        $('#up').show();//显示
    }
    k=zu;

}

function change1(e){
    zz=k;
    var pagesize=6;
    pageall=$("#p").text();
    pageno=e;
    if(e <1)//如果输入页<1页
    { e=1;pageno=1}//就等于第1页 ， 当前页为1
    if(e>pageall)//如果输入页大于最大页
    {e=pageall;pageno=pageall}//输入页和当前页都=最大页
    document.getElementById("all").innerHTML="";//全部清空
    for(var i=0;i<pagesize;i++)
    {
        var div =document.createElement("div");//建立div对象
        div.innerHTML=zz[(e-1)*pagesize+i];//建立显示元素
        document.getElementById("all").appendChild(div);//加入all中
        if(zz[(e-1)*pagesize+i+1]==null)//超出范围跳出
            break
    }
    var ye="";
    for(var j=1;j<=pageall;j++)
    {
        if(e==j)
        {ye=ye+"<span><a href='#' onClick='change1("+j+")' style='color:#FF0000'>"+j+"</a></span> "}
        else
        {ye=ye+"<a href='#' onClick='change1("+j+")'>"+j+"</a> "}
    }
    document.getElementById("a1").innerHTML=pageall;
    document.getElementById("a2").innerHTML=pageno;
    document.getElementById("a3").innerHTML=ye;

    /*如果当前是第一页则：*/

    if (pageno == 1)
    {
        $('#down').hide();//隐藏
    }else {
        $('#down').show();//显示
    }

    /*如果是最后一页则：*/

    if (pageno == pageall)
    {
        $('#up').hide();//隐藏
    }else {
        $('#up').show();//显示
    }
}

//进入房间
function onclick_JoinRoom(room) {
    /**
     * 传递字符串参数
     */
    // alert("进入onclick_JoinRoom");
    // alert(room.getAttribute('thisRoom'));
    var param=room.getAttribute('thisRoom');
    var url = "/roomController/joinInRoom?rId=";
    location.href=url+param;
    // location.href = "/roomController/joinInRoom?rid=" + param;

    // //var param={};两种方式都行
    // // param.stringParams=hidden_input_value;
    // $.ajax({
    //     type : 'POST',
    //     url:"/roomController/joinInRoom",
    //     dataType : 'json',
    //     data:{"rId":param},
    //     // traditional : true,
    //     // async:false,
    //     success:function(data){
    //         // alert("post success!");
    //         if (data) {//根据返回值进行跳转
    //             window.location.href = data;
    //         }
    //     },
    //     error:function (e) {
    //         alert("post error!");
    //     }
    //
    // })

}