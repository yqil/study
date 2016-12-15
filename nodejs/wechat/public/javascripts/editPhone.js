
! function() {
    var vm = new Vue({
        el: "#wxEditPhone",
        data: {
            phone: null,
            validCode: null,
            dialogMsg: "服务器开小差了，请稍后尝试~",
            loaddingMsg: "保存中，请稍后~"
        },
        mounted: function(){
            this.phone = this.getQueryString("phone");
        },
        methods: {
            save: function(){
                var that = this;
                if(this.validCode == "888888"){
                    this.myLoadding.showLoadding();
                    var data = {
                        data: {
                            phone: this.phone
                        }
                    };
                    $.getJSON('/person/saveUser', data, function(data, status, xhr){
                        if(data){
                            that.myLoadding.closeLoadding();
                            window.location.href="/person/index";
                        }else {
                            that.myLoadding.closeLoadding();
                            that.myDialog.showDialog();
                        }
                    });
                }else {
                    this.dialogMsg = "验证码错误";
                    this.myDialog.showDialog();
                }
            }
        }
    });
}();