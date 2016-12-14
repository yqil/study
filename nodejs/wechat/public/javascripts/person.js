! function() {
    var vm = new Vue({
        el: "#wxPerson",
        data: {
            nickName: null,
            mmh: null,
            phone: null,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            var that = this;
            $.getJSON('/person/queryUser', null, function(data, status, xhr){
                if(data && data.status){
                    that.nickName = data.content.nickName;
                    that.mmh = data.content.mmh;
                    that.phone = data.content.phone;
                }else {
                    that.myDialog.showDialog();
                }
            });
        },
        methods: {
            editNickName: function(){
                window.location.href="/person/editPersonNickName?nickName="+this.nickName;
            }
        }
    });
}();