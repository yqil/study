! function() {
    var vm = new Vue({
        el: "#wxIntegral",
        data: {
            integral: 888,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        methods: {
            accessIntegralDetail: function(){
                window.location.href="/integral/detail";
            },
            accessIntegralExchange: function(){
                window.location.href="/integral/exchange";
            },
            accessIntegralLottery: function(){
                window.location.href="/integral/lottery";
            }
        }
    });
}();