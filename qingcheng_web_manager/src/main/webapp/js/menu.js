var menu={
  "data": [
    {
        "path": "1",//菜单项所对应的路由路径
        "title": "首页", //菜单项名称
        "icon":"iconHome",//是否有子菜单，若没有，则为[]
    },
    {
      "path": "2",
      "title": "商品",
      "icon":"iconCommodity",
      "children": [
        {
            "path": "2-1",
            "title": "商品管理",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSp",
            "children":[
                {
                    "path": "2-1-1",
                    "title": "商品列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-1-2",
                    "title": "添加商品",
                    "linkUrl":"commodity-add.html",
                },
                {
                    "path": "2-1-3",
                    "title": "商品审核",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-1-4",
                    "title": "商品回收站",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-1-5",
                    "title": "商品评价",
                    "linkUrl":"sku-comment-list.html",
                }
            ]
        },
        {
            "path": "2-2",
            "title": "添加配置",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "2-2-1",
                    "title": "商品分类",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-2-2",
                    "title": "规格参数",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-2-3",
                    "title": "品牌管理",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "2-2-4",
                    "title": "图片库管理",
                    "linkUrl":"all-medical-list.html",
                }
            ]
        },
      ]
    },
    {
      "path": "3",
      "title": "订单",
      "icon":"iconOrder",
      "children": [
      {
          "path": "3-1",
          "title": "订单管理",
          "linkUrl":"all-medical-list.html",
          "icon":"iconSet",
          "children":[
                {
                    "path": "3-1-1",
                    "title": "订单列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-1-2",
                    "title": "确认收货",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-1-3",
                    "title": "到货提醒",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-1-4",
                    "title": "订单设置",
                    "linkUrl":"all-medical-list.html",
                }
            ]
      },
      {
          "path": "3-2",
          "title": "退款及退货",
          "icon":"iconSet",
          "children":[
                {
                    "path": "3-2-1",
                    "title": "退货申请处理",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-2-2",
                    "title": "退款申请处理",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-2-3",
                    "title": "退货原因设置",
                    "linkUrl":"all-medical-list.html",
                }
            ]
      },
      {
          "path": "3-3",
          "title": "快递单管理",
          "linkUrl":"all-item-list.html",
          "icon":"iconSet",
          "children":[
                {
                    "path": "3-3-1",
                    "title": "快递单模板",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-3-2",
                    "title": "自定义打印项",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "3-3-3",
                    "title": "发货点信息管理",
                    "linkUrl":"all-medical-list.html",
                }
            ]
      },
      ]
  },
    {
      "path": "4",
      "title": "库存",
      "icon":"iconStock",
      "children": [
      {
          "path": "4-1",
          "title": "库存记录",
          "linkUrl":"all-medical-list.html",
          "icon":"iconSet",
          "children":[
            {
                "path": "4-1-1",
                "title": "商品入库",
                "linkUrl":"all-medical-list.html",
            },
            {
                "path": "4-1-2",
                "title": "商品出库",
                "linkUrl":"all-medical-list.html",
            }
          ]
      }
      ]
  },
  {
      "path": "5",
      "title": "用户",
      "icon":"iconUser",
      "children":[
          {
              "path": "5-1",
              "title": "用户管理",
              "linkUrl":"all-medical-list.html",
              "icon":"iconSet",
              "children":[
                {
                    "path": "5-1-1",
                    "title": "用户列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "5-1-2",
                    "title": "购买力筛选",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "5-1-3",
                    "title": "标签管理",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "5-1-4",
                    "title": "会员等级设置",
                    "linkUrl":"all-medical-list.html",
                }
              ]
          },
          {
            "path": "5-2",
            "title": "成长值及匠币",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "5-2-1",
                    "title": "成长值及匠币查询",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "5-2-2",
                    "title": "任务奖励设置",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "5-2-3",
                    "title": "更多规则设置",
                    "linkUrl":"all-medical-list.html",
                }
              ]
        },
      ]
  },
  {
      "path": "6",     
      "title": "促销",     
      "icon":"iconPromotion",
      "children":[
        {
          "path": "6-1",
          "title": "秒杀专区",
          "linkUrl":"all-medical-list.html",
          "icon":"iconSet",
          "children":[
            {
                "path": "6-1-1",
                "title": "秒杀活动列表",
                "linkUrl":"all-medical-list.html",
            },
            {
                "path": "6-1-2",
                "title": "时间段列表",
                "linkUrl":"all-medical-list.html",
            },
            {
                "path": "6-1-3",
                "title": "秒杀提醒通知",
                "linkUrl":"all-medical-list.html",
            },
          ]
        },
        {
            "path": "6-2",
            "title": "优惠券管理",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "6-2-1",
                    "title": "优惠券列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "6-2-2",
                    "title": "添加优惠券",
                    "linkUrl":"all-medical-list.html",
                }
            ]
          },
          {
            "path": "6-3",
            "title": "活动管理",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "6-2-1",
                    "title": "活动列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "6-2-2",
                    "title": "添加活动",
                    "linkUrl":"all-medical-list.html",
                },
            ]
          },
          {
            "path": "6-4",
            "title": "首页推荐",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "6-4-1",
                    "title": "品牌制造商",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "6-4-2",
                    "title": "新鲜好物",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "6-4-3",
                    "title": "人气推荐",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "6-4-4",
                    "title": "专题精选",
                    "linkUrl":"all-medical-list.html",
                },
            ]
          },
      ]        
  },
  {
    "path": "7",     
    "title": "运营",     
    "icon":"iconOperate",
    "linkUrl":"operate.html",
    "children":[
      {
        "path": "7-1",
        "title": "秒杀专区",
        "linkUrl":"operate.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "7-1-1",
              "title": "秒杀活动列表",
              "linkUrl":"operate.html",
          },
          {
              "path": "7-1-2",
              "title": " 时间段列表",
              "linkUrl":"operate-spike-data.html",
          }
        ]
      },
      {
          "path": "7-2",
          "title": "满减专区",
          "linkUrl":"operate.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "7-2-1",
                  "title": "满减活动列表",
                  "linkUrl":"operate.html",
              },
              {
                  "path": "7-2-2",
                  "title": " 添加满减活动",
                  "linkUrl":"operate.html",
              }
          ]
        },
        {
          "path": "7-3",
          "title": "优惠券管理",
          "linkUrl":"operate.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "7-3-1",
                  "title": "优惠券列表",
                  "linkUrl":"operate.html",
              },
              {
                  "path": "7-3-2",
                  "title": "添加优惠券",
                  "linkUrl":"operate.html",
              },
              {
                  "path": "7-3-3",
                  "title": "优惠券查询",
                  "linkUrl":"operate.html",
              },
          ]
        },
        {
          "path": "7-4",
          "title": "活动管理",
          "linkUrl":"operate.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "7-3-1",
                  "title": "活动列表",
                  "linkUrl":"operate.html",
              },
              {
                  "path": "7-3-2",
                  "title": "添加活动",
                  "linkUrl":"operate.html",
              }
          ]
        },
        {
          "path": "7-5",
          "title": "广告管理",
          "linkUrl":"operate.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "7-3-1",
                  "title": "广告列表",
                  "linkUrl":"operate.html",
              },
              {
                  "path": "7-3-2",
                  "title": "添加广告",
                  "linkUrl":"operate.html",
              }
          ]
        }
     ]        
   },
   {
    "path": "8",     
    "title": "内容",     
    "icon":"iconContent",
    "children":[
      {
        "path": "8-1",
        "title": "专题管理",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "8-1-1",
              "title": "专题列表",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "8-1-2",
              "title": "发布专题",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "8-1-3",
              "title": "分类管理",
              "linkUrl":"all-medical-list.html",
          }
        ]
      },
      {
          "path": "8-2",
          "title": "心选主题",
          "linkUrl":"all-medical-list.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "8-2-1",
                  "title": "心选列表",
                  "linkUrl":"all-medical-list.html",
              }
          ]
        },
        {
          "path": "8-3",
          "title": "话题管理",
          "linkUrl":"all-medical-list.html",
          "icon":"iconSet",
          "children":[
              {
                  "path": "8-3-1",
                  "title": "话题列表",
                  "linkUrl":"all-medical-list.html",
              },
              {
                  "path": "8-3-2",
                  "title": "分类管理",
                  "linkUrl":"all-medical-list.html",
              },
          ]
        },
        {
            "path": "8-4",
            "title": "帮助管理",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "8-4-1",
                    "title": "帮助列表",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "8-4-2",
                    "title": "发布帮助",
                    "linkUrl":"all-medical-list.html",
                },
                {
                    "path": "8-4-3",
                    "title": "分类管理",
                    "linkUrl":"all-medical-list.html",
                }
            ]
        },
        {
            "path": "8-5",
            "title": "举报管理",
            "linkUrl":"all-medical-list.html",
            "icon":"iconSet",
            "children":[
                {
                    "path": "8-5-1",
                    "title": "举报列表",
                    "linkUrl":"all-medical-list.html",
                }
            ]
        }
     ]        
   },
   {
    "path": "9",     
    "title": "统计",     
    "icon":"iconStatistics",
    "children":[
      {
        "path": "9-1",
        "title": "统计分析",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "9-1-1",
              "title": "交易统计",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "9-1-2",
              "title": "流量统计",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "9-1-3",
              "title": "商品统计",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "9-1-4",
              "title": "会员统计",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "9-1-5",
              "title": "搜索统计",
              "linkUrl":"all-medical-list.html",
          }
        ]
      }
     ]        
   },
   {
    "path": "10",     
    "title": "财务",     
    "icon":"iconFinance",
    "children":[
      {
        "path": "10-1",
        "title": "财务报表",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "10-1-1",
              "title": "综合统计",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "10-1-2",
              "title": "会员排行",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "10-1-3",
              "title": "销售统计",
              "linkUrl":"all-medical-list.html",
          }
        ]
      },
      {
        "path": "10-2",
        "title": "对账管理",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "10-2-1",
              "title": "对账列表",
              "linkUrl":"all-medical-list.html",
          }
        ]
      }
     ]        
   },
   {
    "path": "11",     
    "title": "设置",     
    "icon":"iconSeting",
    "children":[
      {
        "path": "11-1",
        "title": "平台设置",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "11-1-1",
              "title": "平台信息",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "11-1-2",
              "title": "基本设置",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "11-1-3",
              "title": "消息提醒",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "11-1-4",
              "title": "验证码设置",
              "linkUrl":"all-medical-list.html",
          }
        ]
      },
      {
        "path": "11-2",
        "title": "支付配送",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "11-2-1",
              "title": "运费模板",
              "linkUrl":"all-medical-list.html",
          },
          {
            "path": "11-2-2",
            "title": "物流公司",
            "linkUrl":"all-medical-list.html",
            },
            {
                "path": "11-2-3",
                "title": "支付设置",
                "linkUrl":"all-medical-list.html",
            },
            {
                "path": "11-2-4",
                "title": "区域管理",
                "linkUrl":"all-medical-list.html",
            }
        ]
      }
     ]        
   },
   {
    "path": "12",     
    "title": "权限",     
    "icon":"iconJurisdiction",
    "children":[
      {
        "path": "12-1",
        "title": "权限管理",
        "linkUrl":"all-medical-list.html",
        "icon":"iconSet",
        "children":[
          {
              "path": "12-1-1",
              "title": "部门管理",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "12-1-2",
              "title": "成员管理",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "12-1-3",
              "title": "客服管理",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "12-1-4",
              "title": "操作日志",
              "linkUrl":"all-medical-list.html",
          },
          {
              "path": "12-1-5",
              "title": "数据库管理",
              "linkUrl":"all-medical-list.html",
          }
        ]
      }
     ]        
   }
  ]
}