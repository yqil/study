
! function() {
    var vm = new Vue({
        el: "#wxEditPersonNickName",
        data: {
            nickName: null,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            this.nickName = this.getQueryString("nickName");
        },
        methods: {
            save: function(){
                var that = this;
                var data = {
                    data: {
                        nickName: this.nickName
                    }
                };
                $.getJSON('/person/saveUser', data, function(data, status, xhr){
                    if(data){
                        window.location.href="/person/index";
                    }else {
                        that.myDialog.showDialog();
                    }
                });
            }
        }
    });
}();