# Quick Start Guide

Get your WAZEET project up and running in minutes! This guide will help you take immediate action.

## 🎯 Your First Steps (15 minutes)

### Step 1: Choose Your Application Type (5 minutes)

Pick one based on your needs:

#### Option A: Web API (RESTful Services)
**Best for:** Building backend services, mobile app backends, microservices

```bash
# Navigate to repository root
cd /path/to/https-github.com-Aman2711shah-Final-WAZEET

# Create solution
dotnet new sln -n WAZEET

# Create Web API project
dotnet new webapi -n WAZEET.API -o src/WAZEET.API

# Add to solution
dotnet sln add src/WAZEET.API/WAZEET.API.csproj

# Run the application
cd src/WAZEET.API
dotnet run
```

Visit: `https://localhost:5001/swagger` to see your API documentation!

#### Option B: Web Application (MVC)
**Best for:** Full-stack web applications with server-side rendering

```bash
cd /path/to/https-github.com-Aman2711shah-Final-WAZEET

dotnet new sln -n WAZEET
dotnet new mvc -n WAZEET.Web -o src/WAZEET.Web
dotnet sln add src/WAZEET.Web/WAZEET.Web.csproj

cd src/WAZEET.Web
dotnet run
```

Visit: `https://localhost:5001` to see your web app!

#### Option C: Blazor WebAssembly
**Best for:** Single-page applications with .NET in the browser

```bash
cd /path/to/https-github.com-Aman2711shah-Final-WAZEET

dotnet new sln -n WAZEET
dotnet new blazorwasm -n WAZEET.Blazor -o src/WAZEET.Blazor
dotnet sln add src/WAZEET.Blazor/WAZEET.Blazor.csproj

cd src/WAZEET.Blazor
dotnet run
```

Visit: `https://localhost:5001` to see your Blazor app!

### Step 2: Verify Everything Works (3 minutes)

```bash
# Build the project
dotnet build

# Run tests (create test project first if needed)
dotnet test

# Check for security vulnerabilities
dotnet list package --vulnerable
```

### Step 3: Create Your First Feature (7 minutes)

#### For Web API:

1. **Create a Model** (`src/WAZEET.API/Models/Item.cs`):

```csharp
namespace WAZEET.API.Models
{
    public class Item
    {
        public int Id { get; set; }
        public string Name { get; set; } = string.Empty;
        public string Description { get; set; } = string.Empty;
        public DateTime CreatedAt { get; set; } = DateTime.UtcNow;
    }
}
```

2. **Create a Controller** (`src/WAZEET.API/Controllers/ItemsController.cs`):

```csharp
using Microsoft.AspNetCore.Mvc;
using WAZEET.API.Models;

namespace WAZEET.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ItemsController : ControllerBase
    {
        private static List<Item> _items = new();

        [HttpGet]
        public ActionResult<IEnumerable<Item>> GetAll()
        {
            return Ok(_items);
        }

        [HttpGet("{id}")]
        public ActionResult<Item> GetById(int id)
        {
            var item = _items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();
            
            return Ok(item);
        }

        [HttpPost]
        public ActionResult<Item> Create(Item item)
        {
            item.Id = _items.Count + 1;
            item.CreatedAt = DateTime.UtcNow;
            _items.Add(item);
            
            return CreatedAtAction(nameof(GetById), new { id = item.Id }, item);
        }

        [HttpPut("{id}")]
        public ActionResult Update(int id, Item updatedItem)
        {
            var item = _items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();
            
            item.Name = updatedItem.Name;
            item.Description = updatedItem.Description;
            
            return NoContent();
        }

        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            var item = _items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();
            
            _items.Remove(item);
            return NoContent();
        }
    }
}
```

3. **Test Your API**:

```bash
# Run the application
dotnet run

# In another terminal, test with curl:
# Create an item
curl -X POST https://localhost:5001/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Test Item","description":"My first item"}'

# Get all items
curl https://localhost:5001/api/items

# Or visit https://localhost:5001/swagger in your browser
```

## 🚀 Next Actions (Choose Your Path)

### Path 1: Add Database Support (30 minutes)

```bash
# Add Entity Framework Core
cd src/WAZEET.API
dotnet add package Microsoft.EntityFrameworkCore.SqlServer
dotnet add package Microsoft.EntityFrameworkCore.Tools
dotnet add package Microsoft.EntityFrameworkCore.Design
```

See [NEXT_STEPS.md](NEXT_STEPS.md#step-5-add-database-support) for detailed instructions.

### Path 2: Add Authentication (45 minutes)

```bash
# Add JWT Authentication
dotnet add package Microsoft.AspNetCore.Authentication.JwtBearer
```

See [NEXT_STEPS.md](NEXT_STEPS.md#step-9-add-authentication--authorization) for implementation.

### Path 3: Set Up Testing (20 minutes)

```bash
# Create test project
dotnet new xunit -n WAZEET.API.Tests -o tests/WAZEET.API.Tests
dotnet sln add tests/WAZEET.API.Tests/WAZEET.API.Tests.csproj

# Add test dependencies
cd tests/WAZEET.API.Tests
dotnet add package FluentAssertions
dotnet add package Moq
dotnet add reference ../../src/WAZEET.API/WAZEET.API.csproj
```

### Path 4: Deploy with Docker (30 minutes)

```bash
# Create Dockerfile (see NEXT_STEPS.md for content)
touch Dockerfile
touch docker-compose.yml

# Build and run
docker-compose up
```

## 📚 Essential Reading

1. **Immediate**: [README.md](README.md) - Understand what WAZEET is
2. **Before Contributing**: [CONTRIBUTING.md](CONTRIBUTING.md) - Learn how to contribute
3. **Development Roadmap**: [NEXT_STEPS.md](NEXT_STEPS.md) - Complete development guide
4. **Community Guidelines**: [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) - Be a good community member
5. **Security**: [SECURITY.md](SECURITY.md) - Keep your application secure

## 🆘 Common Issues & Solutions

### Issue: "dotnet command not found"
**Solution**: Install .NET SDK from https://dotnet.microsoft.com/download

### Issue: "Port already in use"
**Solution**: Change the port in `Properties/launchSettings.json` or stop the conflicting application

### Issue: "Certificate error in browser"
**Solution**: Trust the development certificate:
```bash
dotnet dev-certs https --trust
```

### Issue: "Package restore failed"
**Solution**: Clear NuGet cache and restore:
```bash
dotnet nuget locals all --clear
dotnet restore
```

## 📊 Project Health Checklist

After setup, verify:

- [ ] ✅ Project builds without errors: `dotnet build`
- [ ] ✅ Application runs: `dotnet run`
- [ ] ✅ No vulnerable packages: `dotnet list package --vulnerable`
- [ ] ✅ Code committed to Git: `git status`
- [ ] ✅ Documentation read: README, CONTRIBUTING, NEXT_STEPS

## 🎓 Learning Resources

### Quick Tutorials (< 30 min each)
- [ASP.NET Core Quick Start](https://docs.microsoft.com/en-us/aspnet/core/getting-started/)
- [Entity Framework Core Tutorial](https://docs.microsoft.com/en-us/ef/core/get-started/)
- [REST API Best Practices](https://docs.microsoft.com/en-us/azure/architecture/best-practices/api-design)

### Video Guides
- [.NET YouTube Channel](https://www.youtube.com/dotnet)
- [ASP.NET Core Crash Course](https://www.youtube.com/results?search_query=asp.net+core+crash+course)

## 💡 Pro Tips

1. **Use Git from the start**: Commit early and often
   ```bash
   git add .
   git commit -m "feat: add initial project structure"
   ```

2. **Enable auto-save**: Configure your IDE to auto-save files

3. **Use keyboard shortcuts**: 
   - `Ctrl+F5` - Run without debugging (faster)
   - `F5` - Run with debugging
   - `Ctrl+.` - Quick actions and refactorings

4. **Install useful extensions**:
   - Visual Studio: ReSharper, CodeMaid
   - VS Code: C# Dev Kit, REST Client

5. **Bookmark documentation**: Keep ASP.NET docs handy

## 🎯 Your 30-Day Roadmap

**Week 1**: Basic Setup & CRUD Operations
- [ ] Choose and create project type
- [ ] Implement basic CRUD API
- [ ] Add input validation

**Week 2**: Data & Persistence
- [ ] Set up database
- [ ] Add Entity Framework
- [ ] Create migrations

**Week 3**: Authentication & Security
- [ ] Implement authentication
- [ ] Add authorization
- [ ] Security hardening

**Week 4**: Testing & Deployment
- [ ] Write unit tests
- [ ] Create integration tests
- [ ] Set up CI/CD
- [ ] Deploy to cloud

## 📞 Need Help?

1. **Stack Overflow**: Tag questions with `.net`, `asp.net-core`
2. **GitHub Discussions**: Ask in this repository
3. **Discord/Slack**: Join .NET community channels
4. **Documentation**: See [NEXT_STEPS.md](NEXT_STEPS.md) for detailed guides

---

**Ready to start?** Pick your application type and run the commands above. You'll have a working application in 15 minutes! 🚀

**Need more guidance?** Check out [NEXT_STEPS.md](NEXT_STEPS.md) for the complete development roadmap.
