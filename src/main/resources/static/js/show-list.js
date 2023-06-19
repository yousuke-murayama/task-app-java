$(function() {
  $(".modal").modal();

  $(".datepicker").datepicker({
    format: 'yyyy年mm月dd日',
    i18n: {
      months: [
        '1月',
        '2月',
        '3月',
        '4月',
        '5月',
        '6月',
        '7月',
        '8月',
        '9月',
        '10月',
        '11月',
        '12月'
      ],
      monthsShort: [
        '1月',
        '2月',
        '3月',
        '4月',
        '5月',
        '6月',
        '7月',
        '8月',
        '9月',
        '10月',
        '11月',
        '12月',
      ],
      weekdays: [
        '日',
        '月',
        '火',
        '水',
        '木',
        '金',
        '土',
      ],
      weekdaysShort: [
        '日',
        '月',
        '火',
        '水',
        '木',
        '金',
        '土',
      ],
      weekdaysAbbrev: [
        '日',
        '月',
        '火',
        '水',
        '木',
        '金',
        '土',
      ]
    }
  })
});