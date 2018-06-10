<style scoped>
  .layout {
    border: 1px solid #d7dde4;
    background: #f5f7f9;
  }

  .user-info {
    float: right;
    margin-right: 15px;

  }

  a {
    color: #fff;
  }

  .layout-content {
    min-height: 200px;
    margin: 15px;
    overflow: hidden;
    background: #fff;
    border-radius: 4px;
  }

  .layout-content-main {
    padding: 10px;
  }

  .layout-copy {
    text-align: center;
    padding: 10px 0 20px;
    color: #9ea7b4;
  }
</style>
<template>
  <div class="layout">
    <Menu mode="horizontal" theme="dark" :active-key="activeKey" @on-select="menuClick">
      <Menu-item name="index" key="index" style="margin-left: 80px;">
        <Icon type="ios-paper"></Icon>
        首页
      </Menu-item>
      <Menu-item name="cost" key="cost">
        <Icon type="ios-people"></Icon>
        成本管理
      </Menu-item>
      <Menu-item name="product" key="product">
        <Icon type="stats-bars"></Icon>
        产品管理
      </Menu-item>
      <Menu-item name="plm" key="plm">
        <Icon type="ionic"></Icon>
          PLM
        </Menu-item>

      <Menu-item name="salary" key="salary">
        <Icon type="ios-people"></Icon>
        薪资管理
      </Menu-item>

      <Menu-item name="sys" key="sys">
        <Icon type="settings"></Icon>
        系统设置
      </Menu-item>
      <Menu-item name="pers" key="pers" class="user-info">
        <Dropdown >
          <a href="javascript:void(0)">
            <span><Icon class="user-avatar" type="person"></Icon>&nbsp;&nbsp;蔡平</span>
          </a>
          <Dropdown-menu slot="list">
            <Dropdown-item name="person-setting">个人设置</Dropdown-item>
            <Dropdown-item name="logout">退出登录</Dropdown-item>
          </Dropdown-menu>
        </Dropdown>
      </Menu-item>

    </Menu>
    <div class="layout-content">
      <Row>
        <router-view class="layout-content-main"/>
      </Row>
    </div>
    <div class="layout-copy">
      2011-2017 &copy; caiping
    </div>
  </div>
</template>
<script>
  let activeKey = 'index';
  export default {
    data(){
      return {
        activeKey: activeKey
      }
    },
    methods: {
      menuClick(name) {
        if (name.match(/\b(index|cost|product|salary|sys|pers|plm)\b/)) {
          activeKey = name;
          console.log("nav click matched: " + name);
          if (name == 'index') {
            this.$router.push("/a");
            return;
          }else if (name=="cost") {//直接跳转到 研发阶段的 历史成本
            this.$router.push('/a/cost/r/view');
            return;
          }else if(name=='product'){
            this.$router.push('/a/product/work');
            return;
          }else if (name=='salary'){
            this.$router.push('/a/salary/view');
            return;
          }else if (name=='sys'){
            this.$router.push('/a/sys/user');
            return;
          }else if (name=='pml'){
            this.$router.push('/a/plm/material');
            return;
          }



          this.$router.push('/a/' + name);
        }
      },
    }

  }
</script>
