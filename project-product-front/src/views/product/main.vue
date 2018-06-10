<template>

  <div>
    <Row>
      <i-col span="5">
        <Menu @on-select="menuClick" active-key="work">
          <Menu-item name="view" key="view"><Icon type="fork"></Icon>产看产品</Menu-item>
          <Menu-item name="add" key="add"><Icon type="plus-round"></Icon>新增产品</Menu-item>
          <Menu-item name="tree" key="tree"><Icon type="podium"></Icon>产品树</Menu-item>
          <Menu-item name="proc" key="proc"><Icon type="thumbsup"></Icon>产品流程</Menu-item>
          <Menu-item name="work" key="work"><Icon type="ipad"></Icon>产品工位</Menu-item>
        </Menu>
      </i-col>
      <i-col span="19">
        <router-view/>
      </i-col>
    </Row>
  </div>
</template>
<script>

  let activeKey = 'work';

  export default {
    data () {
      return {
        activeKey:activeKey
      }
    },
    methods: {
      menuClick(name) {

        this.$router.push('/a/product/' + name);

        /*
        if (name.match(/\b(view|add|tree|proc|work)\b/)) {
          console.log("nav click matched: " + name);
          this.$router.push('/a/product/' + name);
          activeKey = name;
        }*/
      },
    }
  }
</script>
