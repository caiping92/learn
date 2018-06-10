<template>

  <div>
    <Row>
      <i-col span="5">
        <Menu :active-key="activeKey" :open-keys="oopenKeys"  @on-select="menuClick"  style="margin: 0 0;padding:0 0">
          <Submenu key="r">
            <template slot="title">
              <Icon type="ios-paper"></Icon>
             研发阶段
          </template>
            <Menu-item name="r-stru" key="r-stru"><Icon type="load-d"></Icon>成本构成</Menu-item>
            <Menu-item name="r-coll" key="r-coll"><Icon type="xbox"></Icon>作业归集</Menu-item>
            <Menu-item name="r-view" key="r-view"><Icon type="iphone"></Icon>历年走势</Menu-item>
          </Submenu>
          <Submenu key="2">
            <template slot="title">
              <Icon type="ios-people"></Icon>
             制造阶段
          </template>
            <Menu-item key="1-1">成本构成</Menu-item>
            <Menu-item key="1-2">作业归集</Menu-item>
            <Menu-item key="1-3">历年走势</Menu-item>
          </Submenu>
          <Submenu key="3">
            <template slot="title">
              <Icon type="stats-bars"></Icon>
              销售阶段
          </template>
            <Menu-item key="1-1">成本构成</Menu-item>
            <Menu-item key="1-2">作业归集</Menu-item>
            <Menu-item key="1-3">历年走势</Menu-item>
          </Submenu>
          <Submenu key="4">
            <template slot="title">
              <Icon type="ios-people"></Icon>
              运维阶段
           </template>
            <Menu-item key="1-1">成本构成</Menu-item>
            <Menu-item key="1-2">作业归集</Menu-item>
            <Menu-item key="1-3">历年走势</Menu-item>
          </Submenu>
        </Menu>
      </i-col>
      <i-col span="19">
        <router-view/>
      </i-col>
    </Row>
  </div>
</template>
<script>

//  var activeKey = 'r-stru';
  let activeKey = 'r-view';
  let openKeys = 'r';
  export default {
    data () {
      return {
        model1: '',
        openKeys:openKeys,
        activeKey:activeKey,

      }
    },
    methods: {
      menuClick(name) {
        if (name.match(/\b(r-stru|r-cllo|r-view)\b/)) {
          console.log("nav click matched: " + name.replace(/-/,"/"));
          this.$router.push('/a/cost/' + name.replace(/-/,"/"));
          activeKey = name;
        }
      },
    }
  }
</script>
