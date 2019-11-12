$(function(){
    alert("前方ajax！");
    $.ajax({
        type:"GET",
        url:"/roomController/proRoom",
        // contentType:"application/json",
        dataType:'json',
        // data:{},
        async:false,
        success:function(data){
            alert("success!");
            alert(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
            alert(errorThrown);
        }
    });
})