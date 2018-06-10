<template>

  <div>
    <Row>
      <i-col span="5">
        <Menu @on-select="menuClick" :active-key="activeKey">
          <Menu-item name="user" key="user"><Icon type="person"></Icon>用户管理</Menu-item>
          <Menu-item name="org" key="org"><Icon type="network"></Icon>部门管理</Menu-item>
          <Menu-item name="role" key="role"><Icon type="battery-charging"></Icon>角色管理</Menu-item>
          <Menu-item name="set" key="set"><Icon type="grid"></Icon>系统设置</Menu-item>
          <Menu-item name="dataentry" key="dataentry"><Icon type="ios-shuffle-strong"></Icon>数据录入</Menu-item>
        </Menu>
      </i-col>
      <i-col span="19">
        <router-view/>
      </i-col>
    </Row>
  </div>
</template>
<script>

  let activeKey = 'user';

  export default {
    data () {
      return {
        activeKey:activeKey
      }
    },
    methods: {
      menuClick(name) {
//        this.$router.push('/a/salary' + name);
        if(name=='dataentry') {
          activeKey = "dataentry";
          this.$router.push('/a/sys/dataentry');
        }else{
          activeKey = name;
          this.$router.push('/a/sys/user');
        }
      },
    }
  }
</script>
