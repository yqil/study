! function() {
    Vue.component('my-dialog', {
        // 声明 props
        props: ['message'],
        /*mounted: function(){
            var e = ".my-dialog>div:nth-child(2)";
            var winHeight = window.innerHeight;
            var divHeight = $(e).height();
            var h = (winHeight-divHeight)/2;
            $(e).css("top", h+"px");
        },*/
        methods: {
            iKnow: function(){
                $(".my-dialog").css("display", "none");
            }
        },
        template: '<div class="my-dialog">'+
            '<div></div>'+
            '<div>'+
                '<p>温馨提示</p>'+
                '<p>{{message}}</p>'+
                '<p v-on:click="iKnow">我知道了</p>'+
            '</div>'+
        '</div>'
    });

    Vue.prototype.myDialog = {
        showDialog: function(){
            $(".my-dialog").css("display", "block");
            var e = ".my-dialog>div:nth-child(2)";
            var winHeight = window.innerHeight;
            var divHeight = $(e).height();
            var h = (winHeight-divHeight)/2;
            $(e).css("top", h+"px");
        }
    };
}();

