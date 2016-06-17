var oracledb = require('oracledb');
var http = require('http');

oracledb.getConnection(
  {
    user          : "wecando",
    password      : "Qwer12qw",
    connectString : "localhost:1521:orcl"
  },
  function(err, connection)
  {
	var input_email = 0;
    if (err) { console.error(err); return; }
    connection.execute(
      "SELECT count(*) "
    + "FROM member "
    + "WHERE member_email = " + input_email,
      function(err, result)
      {
        if (err) { console.error(err); return; }
        var value = result.row;
        if (value == 0)	{
        		return true;
        } else {
        		return false;
        }
      });
  });