App = Ember.Application.create();

App.IndexRoute = Ember.Route.extend({
  controllerName: 'application'
});

App.ApplicationController = Ember.Controller.extend({ 
  tableColumns: function() {
    var dateColumn, openColumn, highColumn, lowColumn, closeColumn;
    dateColumn = Ember.Table.ColumnDefinition.create({
      columnWidth: 150,
      textAlign: 'text-align-left',
      headerCellName: 'Date',
      getCellContent: function(row) {
        return row.get('date').toDateString();
      }
    });
    openColumn = Ember.Table.ColumnDefinition.create({
      columnWidth: 100,
      headerCellName: 'Open',
      getCellContent: function(row) {
        return row.get('open').toFixed(2);
      }
    });
    highColumn = Ember.Table.ColumnDefinition.create({
      columnWidth: 100,
      headerCellName: 'High',
      getCellContent: function(row) {
        return row.get('high').toFixed(2);
      }
    });
    lowColumn = Ember.Table.ColumnDefinition.create({
      columnWidth: 100,
      headerCellName: 'Low',
      getCellContent: function(row) {
        return row.get('low').toFixed(2);
      }
    });
    closeColumn = Ember.Table.ColumnDefinition.create({
      columnWidth: 100,
      headerCellName: 'Close',
      getCellContent: function(row) {
        return row.get('close').toFixed(2);
      }
    });
    return [dateColumn, openColumn, highColumn, lowColumn, closeColumn];
  }.property(),
  
  tableContent: function() {
    var generatedContent = [];
    for (var i = 0; i < 100; i++) {
      var date = new Date();
      date.setDate(date.getDate() + i);
      generatedContent.push({
        date: date,
        open:  Math.random() * 100,
        high:  Math.random() * 100 + 50,
        low:   Math.random() * 100 - 50,
        close: Math.random() * 100
      });
    }
    return generatedContent;
  }.property()
});