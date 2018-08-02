<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
        <#include "../common/nav.ftl">
    <#--主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list orderDTOPage.content as orderDTO>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.buyerName}</td>
                        <td>${orderDTO.buyerPhone}</td>
                        <td>${orderDTO.buyerAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.getOrderStatusEnum().message}</td>
                        <td>${orderDTO.getPayStatusEnum().message}</td>
                        <td>${orderDTO.createTime}</td>
                        <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                        <td>
                            <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <li>
                            <a href="#">上一頁</a>
                        </li>
                <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage == index>
                    <li  class="disabled">
                        <a href="#">${index}</a>
                    </li>
                    <#else >
                <li >
                    <a href="/sell/seller/order/list?page=${currentPage}&size=2">${index}</a>
                </li>
                    </#if>
                </#list>
                        <li>
                            <a href="#">下一頁</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg"/>
</audio>
<script src="https://cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    var webSocket =null;
    /*判断 浏览器支持*/
    if('WebSocket' in window){
        webSocket = new WebSocket('ws://localhost:8080/sell/webSocket');
    }else{
        alert('该浏览器不支持 webSocket');
    }
    /*刚刚建立的时候   */
    webSocket.onopen =function(event){
        console.log("建立连接");
    }
    webSocket.onclose = function(event){
        console.log("连接关闭");
    }
    /*消息来了的方法*/
    webSocket.onmessage = function(event){
        console.log("收到消息:"+event.data);
        document.getElementById("notice").play();
    }
    /*发生错误走的方法*/
    webSocket.onerror = function(){
        console.log("发生未知错误");
    }
    window.onbeforeunload= function(){
        webSocket.close();
    }

</script>
</body>
</html>