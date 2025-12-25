# 🎬 MovieReview Hub

MovieReview Hub is a Java-based web application that allows users to explore movies and share their opinions through reviews. The application implements full CRUD (Create, Read, Update, Delete) functionality for movie reviews with proper user authentication and database integration.

---

## 📌 Features

### 🎥 Movie Showcase
- Displays a list of movies with details such as:
  - Title
  - Description
  - Genre
  - Release Year
  - Poster image
- Users can view detailed information for each movie.

### 👤 User Authentication
- Users must register and log in to interact with reviews.
- Only authenticated users can add, edit, or delete reviews.
- Users can modify only their own reviews.

### ✍️ Review Management (CRUD)
- **Create**: Logged-in users can add a review with a rating and comment for any movie.
- **Read**: All users can view reviews added by different users.
- **Update**: Registered users can edit their previously added reviews.
- **Delete**: Registered users can delete their own reviews.

---

## 🛠️ Technology Stack

### Backend
- Java Servlets
- JSP (Java Server Pages)
- JDBC for database connectivity

### Frontend
- HTML
- CSS
- JSP

### Database
- MySQL

---

## 🗄️ Database Design

### Tables Used

#### `users`
| Column Name | Description |
|------------|-------------|
| user_id | Primary Key |
| username | Unique username |
| email | User email |
| password | Encrypted password |

#### `movies`
| Column Name | Description |
|------------|-------------|
| movie_id | Primary Key |
| title | Movie title |
| description | Movie summary |
| genre | Movie genre |
| release_year | Year of release |
| poster | Image path |

#### `reviews`
| Column Name | Description |
|------------|-------------|
| review_id | Primary Key |
| movie_id | Foreign Key → movies |
| user_id | Foreign Key → users |
| rating | Rating given by user |
| comment | Review text |

Foreign key constraints ensure data consistency and integrity.

---

## 🔄 Application Flow

1. User registers or logs in.
2. User browses the list of movies.
3. User selects a movie to view details and reviews.
4. Logged-in users can:
   - Add a new review
   - Edit their existing review
   - Delete their review
5. All changes are reflected instantly using database updates.

---

## ✅ Key Highlights

- Secure access to review operations
- Clean separation of concerns using DAO pattern
- Efficient database interaction using PreparedStatements
- User-specific review permissions
- Scalable CRUD-based architecture

---

## 🚀 Future Enhancements

- Like or dislike reviews
- Movie search and filtering
- Admin panel for managing movies
- Pagination for large movie lists

---

## 📄 Conclusion

MovieReview Hub is a complete CRUD-based Java web application that demonstrates strong understanding of Servlets, JSP, JDBC, and MySQL. It provides a user-friendly platform for movie enthusiasts to explore films and share their opinions securely.
