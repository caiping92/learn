import Vue from 'vue'
import Router from 'vue-router'

import admin from '@/views/admin.vue'
import login from '@/views/login.vue'

import adminIndex from '@/views/admin-index.vue'

import costIndex from '@/views/cost/main.vue'
import costRStru from '@/views/cost/r/stru.vue'
import costColl from '@/views/cost/r/coll.vue'
import costRView from '@/views/cost/r/view.vue'


import productMain from '@/views/product/main.vue'
import productWork from '@/views/product/work.vue'

import salaryMain from '@/views/salary/main.vue'
import salaryView from '@/views/salary/view.vue'


import sysMain from '@/views/sys/main.vue'
import sysUser from '@/views/sys/user.vue'
import sysDataEntry from '@/views/sys/dataentry.vue'


import personInfo from '@/views/person/person-info.vue'


import plm from '@/views/plm/main.vue'
import plmMaterial from '@/views/plm/material.vue'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/a',
      name: 'admin-index',
      component: admin,
      children:[
        {
          path:'',
          component:adminIndex
        },
        {
          path:'cost',
          component:costIndex,
          children:[
            {
              path:'r/stru',
              component:costRStru
            },
            {
              path:'r/coll',
              component:costColl
            },
            {
              path:'r/view',
              component:costRView
            },
          ]
        },
        {
          path:'product',
          component:productMain,
          children:[
            {
              path:'work',
              component:productWork
            }
          ]
        },
        {
          path:'salary',
          component:salaryMain,
          children:[
            {
              path:'view',
              component:salaryView
            }
          ]
        },
        {
          path:'sys',
          component:sysMain,
          children:[
            {
              path:'user',
              component:sysUser
            },
            {
              path:'dataentry',
              component:sysDataEntry
            },

          ]
        },
        {
          path:'pers',
          component:personInfo
        },
        {
          path:'plm',
          component:plm,
          children:[
            {
              path:'material',
              component:plmMaterial
            }
          ]
        },

      ]

    },
  ],
  mode: 'history'
})
