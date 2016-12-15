
! function() {
    var vm = new Vue({
        el: "#wxEditPersonNickName",
        data: {
            nickName: null,
            dialogMsg: "服务器开小差了，请稍后尝试~",
            loaddingMsg: "保存中，请稍后~"
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
                this.myLoadding.showLoadding();
                $.getJSON('/person/saveUser', data, function(data, status, xhr){
                    if(data){
                        that.myLoadding.closeLoadding();
                        window.location.href="/person/index";
                    }else {
                        that.myLoadding.closeLoadding();
                        that.myDialog.showDialog();
                    }
                });
            }
        }
    });
}();