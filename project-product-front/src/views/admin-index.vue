<style>
  .float-left{
    float:left;
  }

  .cleart-all{
    clear: both;
  }
  .chart-margin{
    margin: 50px 100px;
  }

  .index-carousel{
    height: 200px;
    font-size:80px
  }

</style>
<template>
  <div>
    <Carousel>
      <Carousel-item>
        <div class="index-carousel">产品：M单车</div>
      </Carousel-item>
      <Carousel-item>
        <div class="index-carousel">产品：单车锁</div>
      </Carousel-item>
    </Carousel>
    <br/><br/>
    <h1>M企业——产品研发成本概览(2017年12月1日)</h1>
    <br/><br/>
    <hr/>
    <br/>
    <div class=" chart-margin float-left" style="width: auto;height: auto">
      <chart :options="allProductCostStatus"></chart>
    </div>
    <div class="chart-margin float-left" style="width: auto;height: auto">
      <chart :options="companySalary"></chart>
    </div>
    <!--企业市场占有情况-->
    <div class="chart-margin float-left  cleart-all" style="width: auto;height: auto">
      <chart :options="allProductSaleStatus"></chart>
    </div>

  </div>

</template>
<script>

  import {allProductCostStatus,allProductSaleStatus,companySalary} from '@/vo/admin/index.js'

  export default{
    data () {
      return {
        allProductCostStatus: allProductCostStatus,
        allProductSaleStatus: allProductSaleStatus,
        companySalary: companySalary,

      }
    }
  }
</script>
