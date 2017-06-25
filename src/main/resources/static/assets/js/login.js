/**
 * Created by Administrator on 2017/2/28 0028.
 */

var text = document.title
var timerID

function myFunction()
{
    var username, text,password;
    // 获取 id="username,password" 的值
    username = document.getElementById("user").value;
    password = document.getElementById("pw").value;

    if (username=="123" && password=="321") {
        // text = "输入正确";
        alert("输入正确！");
        setTimeout("location.href='home.html'");
    } else {
        // text = "输入错误，请检查用户名和密码是否有误！";
        alert("输入错误，请检查用户名和密码是否有误！")
    }
    document.getElementById("demo").innerHTML = text;
}

function sidewin(){

    $(".side ul li").hover(function(){
        $(this).find(".sidebox").stop().animate({"width":"150px"},200).css({"opacity":"0.6","filter":"Alpha(opacity=100)","background":"#2dae18"})
    },function(){
        $(this).find(".sidebox").stop().animate({"width":"8px"},200).css({"opacity":"0.6","filter":"Alpha(opacity=80)","background":"#66afe9"})
    });

}

//回到顶部
function goTop(){
    $('html,body').animate({'scrollTop':0},600);
}