$(function () {

      $('#addSchedule').click(function () {
        var $listProduct = $('.clone');;
        var $clone = $listProduct.clone();
        //$clone.find(':text').val('');
        $('.list-product-wrapper').append($clone);
        $('.list-product-wrapper .list-product').removeClass('clone');
        $('.list-product-wrapper h2').attr('style', 'display:block');




        $('.scheduleNumberDropdown').on('change', function () {
          //alert(this.value);
          var selected = this.value;
          //var selectedVal = $(this).find('option:selected').val();
          $(this).closest('.list-product').find('.scheduleNumber').text(selected);

        });

      })

      jQuery(document).on('click', 'button.add-btn', function (e) {
        //e.preventDefault();    
        var content = jQuery('#sample_table tr'),
          size = jQuery('.tbl_posts >tbody >tr').length,
          element = null,
          element = content.clone();
        //element.attr('id', 'rec-'+size);
        //element.find('.delete-record').attr('data-id', size);
        parentEl = $(this).closest('.tbl_posts_body')
        //element.find().appendTo('.tbl_posts_body');
        element.appendTo(parentEl);
        //element.find('.sn').val(size);
      });
      jQuery(document).on('click', 'button.remove-row', function () {

        jQuery(this).closest('tr').remove();
      });

/*      $(document).on('click', '.accordion-header', function () {
        $(this).next('.panel').toggle();
        $(this).toggleClass('active')
      });*/
      
      $(document).on('click', '.accordion-header', function () {

    	  $(this).next('.panel').toggle();

    	  $(this).toggleClass('accordion-active');

    	  });

    
    });



    $(document).on('click', '.deleteSchedule', function () {
      $(this).closest('.list-product').remove();
    })