"use strict";
! function() {
    Vue.component('my-location', {
        // 声明 props
        props: ['message'],
        methods: {
            iKnow: function(){
                $(".my-location").css("display", "none");
            }
        },
        template: '<div class="my-location">'+
            '<div></div><div><i></i>'+
            '<span>{{message}}</span></div>'+
        '</div>'
    });

    Vue.prototype.myLocation = {
        showLocation: function(){
            $(".my-location").css("display", "block");
            // var e = ".my-location>div:nth-child(2)";
            // var winHeight = window.innerHeight;
            // var divHeight = $(e).height();
            // var h = (winHeight-divHeight)/2;
            // $(e).css("top", h+"px");
        },
        closeLocation: function(){
            $(".my-location").css("display", "none");
        }
    };
}();