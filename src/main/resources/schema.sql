-- 1. Company 테이블 생성 (참조되는 테이블)
CREATE TABLE IF NOT EXISTS Company (
    company_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- 2. Department 테이블 생성 (참조되는 테이블)
CREATE TABLE IF NOT EXISTS Department (
    dept_id SERIAL PRIMARY KEY,
    company_id BIGINT NOT NULL REFERENCES Company(company_id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL
    );

-- 3. Member 테이블 생성 (참조하는 테이블)
CREATE TABLE IF NOT EXISTS Member (
    member_id SERIAL PRIMARY KEY,
    login_id VARCHAR(100) NOT NULL,
    dept_id BIGINT REFERENCES Department(dept_id) ON DELETE CASCADE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(100) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    image VARCHAR(255),
    "role" VARCHAR(20),
    company_id BIGINT REFERENCES Company(company_id) ON DELETE CASCADE
);

-- 4. Address 테이블 생성 (참조하는 테이블)
CREATE TABLE IF NOT EXISTS Address (
    address_id SERIAL PRIMARY KEY,
    company_id BIGINT REFERENCES Company(company_id) ON DELETE CASCADE,
    longitude DOUBLE PRECISION,
    latitude DOUBLE PRECISION
);

-- 5. Scrap 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS Address (
    member_id SERIAL PRIMARY KEY,
    post_id BIGINT REFERENCES Company(company_id) ON DELETE CASCADE
);

-- 6. Post 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS post (
    post_id SERIAL PRIMARY KEY,
    title VARCHAR(20),
    content VARCHAR(500),
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    member_id BIGINT REFERENCES Member(member_id) ON DELETE CASCADE,
    company_id BIGINT REFERENCES Company(company_id) ON DELETE CASCADE
);

-- 6. comment 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS comment (
    comment_id SERIAL PRIMARY KEY,
    post_id BIGINT REFERENCES post(post_id) ON DELETE CASCADE,
    member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE,
    content VARCHAR(500),
    parent_id BIGINT,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE
);

-- 7. oauth 테이블 생성 (저장)
CREATE TABLE IF NOT EXISTS oauth (
    oauth_id SERIAL PRIMARY KEY,
    member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE,
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE
);

