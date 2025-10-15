# Contributing to WAZEET

First off, thank you for considering contributing to WAZEET! It's people like you that make WAZEET such a great tool.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [How Can I Contribute?](#how-can-i-contribute)
- [Style Guidelines](#style-guidelines)
- [Commit Messages](#commit-messages)
- [Pull Request Process](#pull-request-process)

## 📜 Code of Conduct

This project and everyone participating in it is governed by a commitment to providing a welcoming and inspiring community for all. By participating, you are expected to uphold this code. Please report unacceptable behavior to the project maintainers.

### Our Standards

**Examples of behavior that contributes to creating a positive environment include:**

- Using welcoming and inclusive language
- Being respectful of differing viewpoints and experiences
- Gracefully accepting constructive criticism
- Focusing on what is best for the community
- Showing empathy towards other community members

**Examples of unacceptable behavior include:**

- The use of sexualized language or imagery and unwelcome sexual attention or advances
- Trolling, insulting/derogatory comments, and personal or political attacks
- Public or private harassment
- Publishing others' private information without explicit permission
- Other conduct which could reasonably be considered inappropriate in a professional setting

## 🚀 Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR-USERNAME/https-github.com-Aman2711shah-Final-WAZEET.git
   cd https-github.com-Aman2711shah-Final-WAZEET
   ```

3. **Create a branch** for your changes:
   ```bash
   git checkout -b feature/my-new-feature
   ```

4. **Make your changes** and commit them (see [Commit Messages](#commit-messages))

5. **Push to your fork**:
   ```bash
   git push origin feature/my-new-feature
   ```

6. **Submit a Pull Request** through the GitHub website

## 🤝 How Can I Contribute?

### Reporting Bugs

Before creating bug reports, please check existing issues to avoid duplicates. When you create a bug report, include as many details as possible:

- **Use a clear and descriptive title**
- **Describe the exact steps to reproduce the problem**
- **Provide specific examples** to demonstrate the steps
- **Describe the behavior you observed** and what behavior you expected
- **Include screenshots** if applicable
- **Note your environment** (OS, .NET version, Visual Studio version, etc.)

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion:

- **Use a clear and descriptive title**
- **Provide a detailed description** of the suggested enhancement
- **Explain why this enhancement would be useful**
- **List any alternative solutions** you've considered

### Your First Code Contribution

Unsure where to begin? You can start by looking through issues labeled:

- `good first issue` - Issues that should only require a few lines of code
- `help wanted` - Issues that may be a bit more involved

### Pull Requests

- Fill in the required template
- Follow the [style guidelines](#style-guidelines)
- Include appropriate test cases
- Update documentation as needed
- End all files with a newline

## 🎨 Style Guidelines

### General Guidelines

- **Write clear, readable code** - Code is read more often than it's written
- **Keep it simple** - Avoid unnecessary complexity
- **Comment your code** - Explain the "why", not just the "what"
- **Follow existing patterns** - Match the style of existing code

### .NET/C# Specific Guidelines

- Follow [Microsoft's C# Coding Conventions](https://docs.microsoft.com/en-us/dotnet/csharp/fundamentals/coding-style/coding-conventions)
- Use meaningful variable and method names
- Keep methods focused and small (ideally under 30 lines)
- Use `async`/`await` for asynchronous operations
- Handle exceptions appropriately
- Write XML documentation comments for public APIs

### Code Formatting

```csharp
// Good example
public class UserService
{
    private readonly IUserRepository _userRepository;

    public UserService(IUserRepository userRepository)
    {
        _userRepository = userRepository ?? throw new ArgumentNullException(nameof(userRepository));
    }

    public async Task<User> GetUserByIdAsync(int id)
    {
        if (id <= 0)
        {
            throw new ArgumentException("User ID must be positive", nameof(id));
        }

        return await _userRepository.GetByIdAsync(id);
    }
}
```

## 📝 Commit Messages

Good commit messages are important for maintaining a clear project history.

### Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Documentation only changes
- **style**: Changes that don't affect the code's meaning (formatting, etc.)
- **refactor**: Code changes that neither fix bugs nor add features
- **perf**: Performance improvements
- **test**: Adding or correcting tests
- **chore**: Changes to the build process or auxiliary tools

### Examples

```
feat(auth): add user authentication system

Implement JWT-based authentication with login and logout functionality.
Includes password hashing and token validation.

Closes #123
```

```
fix(api): handle null reference in user endpoint

Add null check before accessing user properties to prevent
NullReferenceException.

Fixes #456
```

## 🔄 Pull Request Process

1. **Update documentation** - Ensure README.md and other docs reflect your changes
2. **Update the changelog** - Add your changes to CHANGELOG.md (if it exists)
3. **Test your changes** - Ensure all tests pass and add new tests as needed
4. **Request review** - Tag appropriate reviewers
5. **Address feedback** - Make changes requested by reviewers
6. **Squash commits** - Consider squashing commits before merging for a cleaner history

### PR Checklist

Before submitting your PR, ensure:

- [ ] Code follows the style guidelines
- [ ] Self-review of code completed
- [ ] Comments added to hard-to-understand areas
- [ ] Documentation updated
- [ ] No new warnings generated
- [ ] Tests added that prove the fix/feature works
- [ ] All tests pass locally
- [ ] Dependent changes merged and published

## 🎯 Development Workflow

### Branching Strategy

- `main` - Production-ready code
- `develop` - Integration branch for features
- `feature/*` - New features
- `bugfix/*` - Bug fixes
- `hotfix/*` - Urgent production fixes

### Testing

```bash
# Run all tests
dotnet test

# Run tests with coverage
dotnet test /p:CollectCoverage=true

# Run specific test
dotnet test --filter "FullyQualifiedName~TestName"
```

### Code Review Guidelines

When reviewing code:

- Be respectful and constructive
- Ask questions rather than make demands
- Suggest improvements, don't just criticize
- Praise good practices
- Explain the reasoning behind your suggestions

## 📚 Additional Resources

- [.NET Documentation](https://docs.microsoft.com/en-us/dotnet/)
- [C# Programming Guide](https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/)
- [GitHub Flow Guide](https://guides.github.com/introduction/flow/)
- [Writing Good Commit Messages](https://chris.beams.io/posts/git-commit/)

## ❓ Questions?

Don't hesitate to ask questions! You can:

- Open an issue with the `question` label
- Reach out to the maintainers
- Check existing issues and discussions

---

Thank you for contributing to WAZEET! 🎉
