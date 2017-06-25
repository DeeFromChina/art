/**
 * 
 * Editable Table
 * 
 * version: 1.0
 * 
 * by Drol
 * 2016-05-12
 * 
 */

function EditableTable(id) {
	this._tableId = id;
	this._$table = $("#" + id);
	this._optMap = {};
}

EditableTable.prototype = {
		
		init : function() {
			var _self = this;
			
			var inputEle = document.createElement("input");
			$(inputEle).addClass("inputCell");
			
			var spanEle = document.createElement("span");
			$(spanEle).addClass("spanCell");
			
			var $rows = this._getRows();
			
			if($rows.length == 0) {
				this._$table.append("<tr></tr>");
				var $rows = this._$table.find("tr");
				var header = $rows[0];
				var emptyRow = $rows[1];
				var $cols = $(header).find("th");
				for(var i = 0; i < $cols.length; i++) {
					$(emptyRow).append("<td></td>");
				}
			}
			
			$rows.each(function(index, domEle){
				$(domEle).click(function(){
					$(_self._table).find(".selected").removeClass("selected");
					$(this).addClass("selected");
				});
				
				$(domEle).find("td").each(function(index, ele){
					var text = $(ele).text();
					$(ele).empty();
					
					if(_self._optMap[index]) {
						var optionInput = $("#"+_self._optMap[index]).clone();
						$(optionInput).val(text);
						$(ele).append(optionInput);
						
						optionInput.addClass("optionCell");
						optionInput.addClass("inputCell");
						optionInput.show();
						optionInput.attr("disabled", "disabled");
						
					} else {
						$(spanEle).text(text);
						$(ele).append($(spanEle).clone());
						
						var tempInput = $(inputEle).clone();
						$(tempInput).val(text);
						$(ele).append(tempInput);
						$(tempInput).hide();
					}
					
				});
			});
			this._reflashData();
		},
		
		_getRows : function() {
			return this._$table.find("tr:has(td)");
		},
		
		_reflashData : function() {
			var _self = this;
			this._data = [];
			var $rows = this._getRows();
			$rows.each(function(index, domEle){
				var array = [];
				$(domEle).find(".inputCell").each(function(index, ele){
					var spanCell = $(ele).siblings(".spanCell")[0];
					if(spanCell) spanCell.innerText = $(ele).val();
					array[array.length] = $(ele).val();
				});
				_self._data[_self._data.length] = array;
			});
		},
		
		_reflashTable : function() {
			var _self = this;
			var $rows = this._getRows();
			
			if(this._data.length < $rows.length) {
				for(var i = 0; i < $rows.length - this._data.length; i++) {
					$($rows[i]).remove();
				}
			}
			$rows = this._getRows();
			
			for(var i = 0; i < this._data.length; i++) {
				if(i >= $rows.length) {
					this.newRow();
					$rows = this._getRows();
 				}
				
				var $columns = $($rows[i]).find(".inputCell");
				for(var j = 0; j < $columns.length; j++) {
					var ele = $columns[j];
					ele.value = this._data[i][j];
					var spanCell = $(ele).siblings(".spanCell")[0];
					if(spanCell) spanCell.innerText = ele.value;
				}
			}
		},
		
		newRow : function() {
			var _self = this;
			var $rows = this._getRows();
			var lastRow = $rows[$rows.length - 1];
			$(lastRow).clone()
				.appendTo(this._$table)
				.click(function(){
					$(_self._table).find(".selected").removeClass("selected");
					$(this).addClass("selected");
				});
			$(_self._table).find(".selected").removeClass("selected");
		},
		
		deleteRow : function() {
			var $rows = this._getRows();
			if($rows.length > 1)
				this._getRows().remove(".selected");
		},
		
		enableEdit : function() {
			this._$table.find(".spanCell").hide();
			this._$table.find(".inputCell").show();
			this._$table.find(".optionCell").removeAttr("disabled");
			this._isEditable = true;
		},
		
		disableEdit : function() {
			this._$table.find(".spanCell").show();
			this._$table.find(".inputCell").hide();
			this._$table.find(".optionCell").show();
			this._$table.find(".optionCell").attr("disabled", "disabled");
			this._isEditable = false;
		},
		
		isEditable : function() {
			return this._isEditable;
		},
		
		commit : function() {
			this._reflashData();
		},
		
		rollback : function() {
			this._reflashTable();
		},
		
		getData : function() {
			return this._data;
		},
		
		getEditingData : function() {
			var editingData = [];
			var $rows = this._getRows();
			$rows.each(function(index, domEle){
				var array = [];
				$(domEle).find(".inputCell").each(function(index, ele){
					array[array.length] = $(ele).val();
				});
				editingData[editingData.length] = array;
			});
			
			return editingData;
		},
		
		getEditingInputs : function() {
			var editingInputs = [];
			var $rows = this._getRows();
			$rows.each(function(index, domEle){
				var array = [];
				$(domEle).find(".inputCell").each(function(index, ele){
					array[array.length] = ele;
				});
				editingInputs[editingInputs.length] = array;
			});
			
			return editingInputs;
		},
		
		setOption : function(column, optId) {
			this._optMap[column] = optId;
		}
}