<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="History.aspx.cs" Inherits="OnlineClothing.History" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>History</title>
     <link href="css/HistoryStyle.css" rel="stylesheet" />
</head>
<body>
    <div>
    <form id="form1" runat="server">
         
            <div class="history">
                Delivered Items
            </div>
        <div class="main">
            <asp:GridView ID="GridView2"  runat="server" CellPadding="4" ForeColor="#333333" GridLines="Vertical" AutoGenerateColumns="False" DataKeyNames="deliverId,employeeId" DataSourceID="SqlDataSource1" Height="199px" Width="600px" style="margin-bottom: 30px; margin-right: 0px;" >
                <AlternatingRowStyle BackColor="White" />
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
                <EditRowStyle BackColor="#7C6F57" />
                <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#E3EAEB" />
                <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
                <SortedAscendingCellStyle BackColor="#F8FAFA" />
                <SortedAscendingHeaderStyle BackColor="#246B61" />
                <SortedDescendingCellStyle BackColor="#D4DFE1" />
                <SortedDescendingHeaderStyle BackColor="#15524A" />
            </asp:GridView>
            
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:clothingDatabaseConnectionString %>" SelectCommand="SELECT * FROM [Delivery] WHERE track='True'"></asp:SqlDataSource>
            
         <asp:Button ID="back" runat="server"  Text="Back" OnClick="back_Click" CssClass="bac" />
            </div>
        
    </form>
        </div>
</body>
</html>
