 var temperatureValue=0;
 var timeValue=20;
 var timerId ;
var data_type = ['airconForm', 'lightsForm'];
        var current_data = get_currentdata();

        function get_currentdata() {
            let dataset = {};
            $.each(data_type, function (i, v) {
                let arr = localStorage.getItem(v) != null ? JSON.parse(localStorage.getItem(v)) : [false, false, false, false, false, false];
                dataset[v] = arr;
            });
            return dataset;
        }

        function get_timeline() {
            let v = 'timeline';
            let arr = localStorage.getItem(v) != null ? JSON.parse(localStorage.getItem(v)) : [];
            return arr;
        }

        function fn_set_checkbox() {
            current_data = get_currentdata();
            $.each(data_type, function (i, v) {
                $("#" + v).find('input[type=checkbox]').each(function (idx, val) {
                    $(val).prop('checked', current_data[v][idx]);
                });
            });
        }

        function fn_init_timeline() {
            let current_timeline = get_timeline();
            for (var i = Math.max(0, current_timeline.length - 10); i < current_timeline.length; i++) {
                display_timeline(current_timeline[i].device, current_timeline[i].floor, current_timeline[i].status, current_timeline[i].active);
            }
        }

        function fn_set_timeline(p_device, p_floor, p_status, _p_time) {
            let current_timeline = get_timeline();
            current_timeline.push({'device': p_device, 'floor': p_floor, 'status': p_status, 'active': _p_time});
            localStorage.setItem('timeline', JSON.stringify(current_timeline));
        }

        let current_timeline = get_timeline();

        var rowsPerPage = 13;
        var currentPage = 1;

        function display_timeline(p_device, p_floor, p_status, formattedTime) {
            var productsAreaWrapper = document.querySelector('.products-area-wrapper');
            var newRow = document.createElement('div');
            newRow.className = 'products-row';
            const controlType2 = p_device;
            var isChecked = p_status;

            var str = "";
            str += '<div class="product-cell image">' +
                '<span>' + controlType2 + '</span>' +
                '</div>' +
                '<div class="product-cell category"><span class="cell-label">Floor:</span>' + p_floor + '</div>' +
                '<div class="product-cell status-cell">' +
                '<span class="cell-label">Status:</span>' +
                '<span class="status ' + (isChecked ? 'active' : 'disabled') + '">' + (isChecked ? 'Active' : 'Disabled') + '</span>' +
                '</div>' +
                '<div class="product-cell sales"><span class="cell-label">Active Record:</span>' + formattedTime + '</div>';
            newRow.innerHTML = str;

            if (isChecked) {
                var statusElement = newRow.querySelector('.status');
                statusElement.classList.remove('disabled');
            }

            var existingRows = productsAreaWrapper.querySelectorAll('.products-row');

            var addedIndex = Array.from(existingRows).indexOf(document.activeElement) + 1;
            if (addedIndex < existingRows.length) {
                productsAreaWrapper.insertBefore(newRow, existingRows[addedIndex]);
            } else {
                productsAreaWrapper.appendChild(newRow);
            }
            currentPage = 1;
            updatePageDisplay();
        }

        function handlePrevPage() {
            if (currentPage > 1) {
                currentPage--;
                updatePageDisplay();
            }
        }

        function updatePageDisplay() {
            var productsAreaWrapper = document.querySelector('.products-area-wrapper');
            var existingRows = productsAreaWrapper.querySelectorAll('.products-row');
            var startIndex = (currentPage - 1) * rowsPerPage;
            var endIndex = startIndex + rowsPerPage;

            existingRows.forEach((row, index) => {
                if (index >= startIndex && index < endIndex) {
                    row.style.display = 'flex';
                } else {
                    row.style.display = 'none';
                }
            });

            var currentPageInfo = document.getElementById('current-page');
            var totalPagesInfo = document.getElementById('total-pages');
            currentPageInfo.innerText = currentPage;
            totalPagesInfo.innerText = getTotalPages();
        }

        function getTotalPages() {
            var productsAreaWrapper = document.querySelector('.products-area-wrapper');
            var existingRows = productsAreaWrapper.querySelectorAll('.products-row');
            return Math.ceil(existingRows.length / rowsPerPage);
        }

        function handleNextPage() {
            var totalPage = getTotalPages();
            if (currentPage < totalPage) {
                currentPage++;
                updatePageDisplay();
            } else {
                alert("마지막 페이지입니다.");
                updatePageDisplay();
            }
        }

        $(document).ready(function () {
            fn_set_checkbox();
            fn_init_timeline();
            document.getElementById('saveButton').addEventListener('click', saveTimeInput);
            $("table input[type=checkbox]").change(function () {
                var obj = get_currentdata();
                var checkbox = $(this);
                var form = $(this).closest('form');
                var form_id = $(form).attr('id');
                var table_id = $(form).children().attr('id');
                var floor = 0;

                var data = $(form).find('input[type=checkbox]').each(function (i, v) {
                    obj[form_id][i] = $(v).prop('checked');
                    if ($(checkbox).attr('id') == $(v).attr('id')) {
                        floor = i + 1;
                    }
                });

                localStorage.setItem(form_id, JSON.stringify(obj[form_id]));

                var currentTime = new Date();
                var formattedTime = (currentTime.getMonth() + 1).toString().padStart(2, '0') + '/' +
                    currentTime.getDate().toString().padStart(2, '0') + ' ' +
                    currentTime.getHours().toString().padStart(2, '0') + ':' +
                    currentTime.getMinutes().toString().padStart(2, '0');

                fn_set_timeline(table_id, floor, $(this).prop('checked'), formattedTime);
                display_timeline(table_id, floor, $(this).prop('checked'), formattedTime);
            });
            function warningTimeLine(device,floor){
            	
            	var productsAreaWrapper = document.querySelector('.products-area-wrapper');
                var newRow = document.createElement('div');
                newRow.className = 'products-row';
                const controlType2 = device;
                var isChecked = "active";
                var currentTime = new Date();
                var formattedTime = (currentTime.getMonth() + 1).toString().padStart(2, '0') + '/' +
                    currentTime.getDate().toString().padStart(2, '0') + ' ' +
                    currentTime.getHours().toString().padStart(2, '0') + ':' +
                    currentTime.getMinutes().toString().padStart(2, '0');
                
                var str = "";
                str += '<div class="product-cell image">' +
                '<span>' + device + '</span>' +
                 '</div>' +
                 '<div class="product-cell category"><span class="cell-label">Floor:</span>' + floor + '</div>' +
                 '<div class="product-cell status-cell">' +
                     '<span class="cell-label">Status:</span>' +
                     '<span class="status ' + (isChecked ? 'active' : 'disabled') + '">' + (isChecked ? 'Active' : 'Disabled') +'<img src="./resources/image/control_img/warning.png" alt="warning">'+ '</span>' +
                 '</div>' +
                 '<div class="product-cell sales"><span class="cell-label">Active Record:</span>' + formattedTime + '</div>'
                newRow.innerHTML = str;

                if (isChecked) {
                    var statusElement = newRow.querySelector('.status');
                    statusElement.classList.remove('disabled');
                }

                var existingRows = productsAreaWrapper.querySelectorAll('.products-row');

                var addedIndex = Array.from(existingRows).indexOf(document.activeElement) + 1;
                if (addedIndex < existingRows.length) {
                    productsAreaWrapper.insertBefore(newRow, existingRows[addedIndex]);
                } else {
                    productsAreaWrapper.appendChild(newRow);
                }
                currentPage = 1;
                updatePageDisplay();
            }
            function requestDataPeriodically() {
                // 분마다 데이터 재요청 함수
            	current_data = get_currentdata();
            	 $.ajax({
            	        type: 'POST',
            	        url: curl + 'control/getControlList',
            	        contentType: 'application/json',
            	        success: function (data) {
            	          for (let i = 0; i < 7; i++) {
            	        	  $('#acdata' + (i + 1)).text(String(data[i].bwInDegc) + ' / ' + String(data[i].bwOutDegc));
            	        	  $('#lidata' + (i + 1)).text(String(data[i].bwInLux) + ' / ' + String(data[i].bwOutSun));

            	        	  if(current_data.airconForm[i]){
            	        		  if(data[i].bwInDegc>data[i].bwOutDegc||data[i].bwInDegc<=temperatureValue){
            	        			  warningTimeLine("awarning",i+1);
            	        		  }
            	        			  
            	        	  }
            	        	  if(current_data.lightsForm[i]){
            	        		   if(data[i].bwOutSun>80 ){
            	        			  warningTimeLine("warning",i+1);
            	        		   }
            	        		  
            	        	  }
            	        	  
            	          }
            	            
            	            // 경고를 위한
            	        },
            	        error: function (error) {
            	            console.error("Error fetching data:", error);
            	        }
            	    });
            }
            function saveTimeInput() {
                timeValue = parseInt(document.getElementById('timeInput').value);

                if (isNaN(timeValue) || timeValue <= 0) {
                    alert('Please enter a valid numeric value for time.');
                } else {
                    alert('Time interval set to ' + timeValue + ' seconds.');
                    starter(requestDataPeriodically, timeValue);
                }
            }

            function starter(functions, timeValue) {
                
                clearInterval(timerId); // 기존 타이머 중지
                timerId = setInterval(functions, timeValue * 1000);
            }

            timerId = setInterval(requestDataPeriodically, timeValue * 1000);
        });// redey 끝
        
        
        
        function updateView(key, obj) {
            $('table').hide();
            $('.heading').hide();
            $("#" + $(obj).attr('data-dataset')).show();
            $("#" + $(obj).attr('data-head')).show();
        }

        function handleAllClear() {
            var userConfirmed = window.confirm("Are you sure you want to clear all content?");
            if (userConfirmed) {
                window.localStorage.removeItem('timeline');
                currentPage = 1;
                updatePageDisplay();
                var totalPagesInfo = document.getElementById('total-pages');
                totalPagesInfo.innerText = 1;
                window.location.reload();
            }
        }

        function handleButtonClick() {
            sortRowsByDate();
            isSortAscending = !isSortAscending;
        }

        function sortRowsByDate() {
            var productsAreaWrapper = document.querySelector('.products-area-wrapper ');
            var rows = Array.from(productsAreaWrapper.children);
            rows.sort(function (a, b) {
                var dateA = getDateFromRow(a);
                var dateB = getDateFromRow(b);

                if (isSortAscending) {
                    return dateA - dateB;
                } else {
                    return dateB - dateA;
                }
            });

            rows.forEach(function (row) {
                productsAreaWrapper.appendChild(row);
            });
        }

        function getDateFromRow(row) {
            var dateString = row.querySelector('.sales').innerText;
            var dateParts = dateString.split('/');
            var timeParts = dateParts[1].split(':');
            var month = parseInt(dateParts[0], 10);
            var day = parseInt(timeParts[0], 10);
            var hour = parseInt(timeParts[1], 10);
            var minute = parseInt(dateParts[1], 10);
            return new Date(0, month - 1, day, hour, minute);
        }
        
        /* Setting rotate하면서 보여주는 동작*/
        function rotateElement(element) {
       var setTmpElement = document.querySelector('.setTmp');
       var currentOpacity = parseFloat(window.getComputedStyle(setTmpElement).opacity);
       element.style.transform = (element.style.transform === 'rotate(360deg)') ? 'rotate(0deg)' : 'rotate(360deg)';
       setTmpElement.classList.toggle('visible');
       setTmpElement.style.opacity = (setTmpElement.classList.contains('visible')) ? 1 : 0;
     }
     /* save 버튼 눌렀을때 처리*/
        function validateInput(input) {
            input.value = input.value.replace(/[^0-9]/g, '');
          }

          function saveTemperature() {
            temperatureValue = document.getElementById('temperatureInput').value;

            if (temperatureValue.trim() === '') {
              alert('Please enter a numeric value for temperature.');
            }else {
              alert('Are you sure you want to set the temperature to ' + temperatureValue + '°C?');
            }
          }
          
