-- 1. Company 테이블
CREATE TABLE IF NOT EXISTS company (
                                       company_id SERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL
);

-- 2. Department 테이블
CREATE TABLE IF NOT EXISTS department (
                                          dept_id SERIAL PRIMARY KEY,
                                          company_id BIGINT NOT NULL REFERENCES company(company_id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL
);

-- 3. Member 테이블
CREATE TABLE IF NOT EXISTS member (
                                      member_id SERIAL PRIMARY KEY,
                                      login_id VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    image VARCHAR(255),
    role VARCHAR(20),
    dept_id BIGINT REFERENCES department(dept_id) ON DELETE CASCADE,
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE
);

-- 4. Address 테이블
CREATE TABLE IF NOT EXISTS address (
                                       address_id SERIAL PRIMARY KEY,
                                       company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE,
    longitude DOUBLE PRECISION,
    latitude DOUBLE PRECISION
);

-- 5. Scrap 테이블 (member가 post를 스크랩함)
CREATE TABLE IF NOT EXISTS scrap (
                                     scrap_id SERIAL PRIMARY KEY,
                                     member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE,
    post_id BIGINT REFERENCES post(post_id) ON DELETE CASCADE
);

-- 6. Post 테이블
CREATE TABLE IF NOT EXISTS post (
                                    post_id SERIAL PRIMARY KEY,
                                    title VARCHAR(100),
    content VARCHAR(1000),
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE,
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE
);

-- 7. Comment 테이블
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

-- 8. OAuth 테이블
CREATE TABLE IF NOT EXISTS oauth (
                                     oauth_id SERIAL PRIMARY KEY,
                                     member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE,
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS restaurant (
    restaurant_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    food_type VARCHAR(100),
    open_time TIME,
    close_time TIME,
    longitude DOUBLE PRECISION,
    latitude DOUBLE PRECISION,
    atmosphere VARCHAR(100),
    image_url VARCHAR(500),
    company_id BIGINT REFERENCES company(company_id) ON DELETE CASCADE -- 회사 소속
);

CREATE TABLE IF NOT EXISTS meal_party (
                                          party_id SERIAL PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
    restaurant_id BIGINT REFERENCES restaurant(restaurant_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS meal_party_member (
                                                 id SERIAL PRIMARY KEY,
                                                 party_id BIGINT REFERENCES meal_party(party_id) ON DELETE CASCADE,
    member_id BIGINT REFERENCES member(member_id) ON DELETE CASCADE
);