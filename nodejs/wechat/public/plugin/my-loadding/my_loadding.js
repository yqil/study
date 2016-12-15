! function() {
    Vue.component('my-loadding', {
        // 声明 props
        props: ['message'],
        methods: {
            iKnow: function(){
                $(".my-loadding").css("display", "none");
            }
        },
        template: '<div class="my-loadding">'+
            '<div></div><div><i></i>'+
            '<span>{{message}}</span></div>'+
        '</div>'
    });

    Vue.prototype.myLoadding = {
        showLoadding: function(){
            $(".my-loadding").css("display", "block");
            var e = ".my-loadding>div:nth-child(2)";
            var winHeight = window.innerHeight;
            var divHeight = $(e).height();
            var h = (winHeight-divHeight)/2;
            $(e).css("top", h+"px");
        },
        closeLoadding: function(){
            $(".my-loadding").css("display", "none");
        }
    };
}();