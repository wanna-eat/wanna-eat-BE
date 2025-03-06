-- 1. Company 테이블 생성 (참조되는 테이블)
CREATE TABLE IF NOT EXISTS Company (
    companyId SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- 2. Department 테이블 생성 (참조되는 테이블)
CREATE TABLE IF NOT EXISTS Department (
    deptId SERIAL PRIMARY KEY,
    companyId BIGINT NOT NULL REFERENCES Company(CompanyId) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL
    );

-- 3. Member 테이블 생성 (참조하는 테이블)
CREATE TABLE IF NOT EXISTS Member (
    memberId SERIAL PRIMARY KEY,
    deptId BIGINT REFERENCES Department(deptId) ON DELETE CASCADE,
    nickname VARCHAR(100) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    createdDate TIMESTAMP NOT NULL DEFAULT NOW(),
    modifiedDate TIMESTAMP NOT NULL DEFAULT NOW(),
    image VARCHAR(255),
    role VARCHAR(20),
    companyId BIGINT REFERENCES Company(CompanyId) ON DELETE CASCADE
);

-- 4. Address 테이블 생성 (참조하는 테이블)
CREATE TABLE IF NOT EXISTS Address (
    addressId SERIAL PRIMARY KEY,
    companyId BIGINT REFERENCES Company(companyId) ON DELETE CASCADE,
    longitude DOUBLE PRECISION,
    latitude DOUBLE PRECISION
);

-- 5. Scrap 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS Address (
    memberId SERIAL PRIMARY KEY,
    postId BIGINT REFERENCES Company(companyId) ON DELETE CASCADE
);

-- 6. Post 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS post (
    postId SERIAL PRIMARY KEY,
    title VARCHAR(20),
    content VARCHAR(500),
    createdDate TIMESTAMP NOT NULL DEFAULT NOW(),
    modifiedDate TIMESTAMP NOT NULL DEFAULT NOW(),
    userId BIGINT REFERENCES Member(memberId) ON DELETE CASCADE,
    companyId BIGINT REFERENCES Company(companyId) ON DELETE CASCADE
);

-- 7. Comment 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS comment (
    commentId SERIAL PRIMARY KEY,
    postId BIGINT REFERENCES Post(postId) ON DELETE CASCADE,
    memberId BIGINT REFERENCES Member(memberId) ON DELETE CASCADE,
    content VARCHAR(500),
    parent_id BIGINT,
    createdDate TIMESTAMP NOT NULL DEFAULT NOW(),
    modifiedDate TIMESTAMP NOT NULL DEFAULT NOW(),
    companyId BIGINT REFERENCES Company(companyId) ON DELETE CASCADE
);

-- 7. OAuth 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS oAuth (
    oauthId SERIAL PRIMARY KEY,
    memberId BIGINT REFERENCES Member(memberId) ON DELETE CASCADE,
    companyId BIGINT REFERENCES Company(companyId) ON DELETE CASCADE
);

