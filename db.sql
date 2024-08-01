create database electric_invoice;
use electric_invoice;

CREATE TABLE Customers
(
    CustomerID   varchar(100) PRIMARY KEY,
    FullName     NVARCHAR(100),
    CustomerType NVARCHAR(50),      -- 'Vietnamese' or 'Foreign'
    Quota        INT          NULL, -- Applicable only for Vietnamese customers
    Nationality  NVARCHAR(50) NULL  -- Applicable only for Foreign customers
);
select *
from Customers;
CREATE TABLE Invoices
(
    InvoiceID   INT PRIMARY KEY IDENTITY (1,1),
    CustomerID  varchar(100),
    InvoiceDate DATE,
    Quantity    DECIMAL(10, 2),
    UnitPrice   DECIMAL(10, 2),
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TRIGGER trg_UpdateTotalAmount
    ON Customers
    AFTER UPDATE
              AS
BEGIN
    IF UPDATE(Quota)
BEGIN
UPDATE i
SET i.TotalAmount =
        CASE
            WHEN i.Quantity <= c.Quota THEN i.Quantity * i.UnitPrice
            ELSE c.Quota * i.UnitPrice + (i.Quantity - c.Quota) * i.UnitPrice * 2.5
            END
    FROM Invoices i
                     INNER JOIN inserted ins ON i.CustomerID = ins.CustomerID
    INNER JOIN deleted d ON ins.CustomerID = d.CustomerID
    INNER JOIN Customers c ON i.CustomerID = c.CustomerID
WHERE d.Quota <> ins.Quota;
END
END


