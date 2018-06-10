<template>
  <div>
    <div style="margin-top: 150px;margin-bottom: 40px;font-size: 35px;">
      <span style="color: white">M企业产品成本管理系统</span>
    </div>
    <div id="login">
      <i-form  :label-width="80" >
        <Form-item>
          用户名：&nbsp;<i-input placeholder="请输入用户名" style="width: 300px"></i-input>
        </Form-item>
        <Form-item >
          密&nbsp;&nbsp;&nbsp;&nbsp;码：&nbsp;<i-input  type="Password"  placeholder="请输入密码" style="width: 300px"></i-input>
        </Form-item>
        <Form-item>
          <i-button type="primary" @click="submit">登录</i-button>
          <i-button type="ghost" style="margin-left: 8px">清空</i-button>
        </Form-item>
      </i-form>

    </div>

  </div>

</template>

<script>
export default {
  name: 'main',
  data () {
    return {
     masg:''
    }
  },
  methods:{
    submit: function () {
      this.$router.push({path:'/a'})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  #login{
    margin-left: 25%;
    width: 50%;
    background-color:#f5f7f9 ;
    padding:100px 100px;
  }

h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
