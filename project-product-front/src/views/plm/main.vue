<template>

  <div>
    <Row>
      <i-col span="5">
        <Menu @on-select="menuClick" active-key="material">
          <Menu-item name="material" key="material"><Icon type="settings"></Icon>原材料</Menu-item>
          <Menu-item name="r" key="r"><Icon type="information-circled"></Icon>产品设计</Menu-item>
          <Menu-item name="purc" key="purc"><Icon type="chevron-left"></Icon>采购管理</Menu-item>
          <Menu-item name="m" key="m"><Icon type="hammer"></Icon>产品制造</Menu-item>
          <Menu-item name="s" key="s"><Icon type="planet"></Icon>产品销售</Menu-item>
          <Menu-item name="o" key="o"><Icon type="nuclear"></Icon>产品运维</Menu-item>
        </Menu>
      </i-col>
      <i-col span="19">
        <router-view/>
      </i-col>
    </Row>
  </div>
</template>
<script>

  let activeKey = 'material';

  export default {
    data () {
      return {
        activeKey:activeKey
      }
    },
    methods: {
      menuClick(name) {
//        this.$router.push('/a/salary' + name);
        this.$router.push('/a/plm/material');
      },
    }
  }
</script>
