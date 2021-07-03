using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(OnlineClothing.Startup))]
namespace OnlineClothing
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
