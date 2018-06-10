<template>

  <div>
    <Row>
      <i-col span="5">
        <Menu @on-select="menuClick" active-key="work">
          <Menu-item name="view" key="view"><Icon type="ipad"></Icon>查看薪资</Menu-item>
          <Menu-item name="mana" key="mana"><Icon type="nuclear"></Icon>管理薪资</Menu-item>
        </Menu>
      </i-col>
      <i-col span="19">
        <router-view/>
      </i-col>
    </Row>
  </div>
</template>
<script>

  let activeKey = 'mana';

  export default {
    data () {
      return {
        activeKey:activeKey
      }
    },
    methods: {
      menuClick(name) {
//        this.$router.push('/a/salary' + name);
        this.$router.push('/a/salary/view');
      },
    }
  }
</script>
