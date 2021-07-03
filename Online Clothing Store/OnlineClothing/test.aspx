<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="test.aspx.cs" Inherits="OnlineClothing.test" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Delivery page</title>
     <link href="css/HomeStyle.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
       <div >
        <div class="headline">
        
            Products to deliver
        
        </div>

        <div class="assigngw">
    
            
    
        <asp:GridView ID="GridView1"  runat="server" CellPadding="4" ForeColor="#333333" GridLines="Vertical" AutoGenerateColumns="False" DataKeyNames="deliverId,employeeId" DataSourceID="SqlDataSource1" Height="199px" Width="1116px" style="margin-bottom: 30px; margin-left: 0px;"  >
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
            <Columns>
                 

                <asp:BoundField DataField="deliverId" HeaderText="deliverId" ReadOnly="True" SortExpression="deliverId" >
                <ItemStyle HorizontalAlign="Center" />
                </asp:BoundField>
                <asp:BoundField DataField="employeeId" HeaderText="employeeId" SortExpression="employeeId" ReadOnly="True" >
                <ItemStyle HorizontalAlign="Center" />
                </asp:BoundField>
                 <asp:CheckBoxField DataField="track" HeaderText="track" SortExpression="track" >
            	<ItemStyle HorizontalAlign="Center" />
				</asp:CheckBoxField>
            </Columns>
            <EditRowStyle BackColor="#999999" />
            <EmptyDataTemplate>
                
            </EmptyDataTemplate>
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#E9E7E2" />
            <SortedAscendingHeaderStyle BackColor="#506C8C" />
            <SortedDescendingCellStyle BackColor="#FFFDF8" />
            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
        </asp:GridView>
            
            
            
            <asp:Button ID="button" runat="server"  Text="Done" OnClick="button_Click" Height="42px" Width="232px" />
           
            
            </div>
    
       
    </div>
   
          
    	<asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:clothingDatabaseConnectionString %>" SelectCommand="SELECT * FROM [Delivery] WHERE track='False'"></asp:SqlDataSource>
   
          
    </form>
    
</body>
</html>