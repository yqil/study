
! function() {
    var vm = new Vue({
        el: "#wxEditMmh",
        data: {
            mmh: null,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        }
        methods: {
            save: function(){
                var that = this;
                var data = {
                    data: {
                        mmh: this.mmh
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